package org.pkgsrc.intellij.util

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType
import com.intellij.util.ArrayUtil

/**
 * Splits a character sequence into tokens by repeatedly looking at the
 * current character and skipping it.
 */
abstract class SkipLexer : Lexer() {

    private var buf = ArrayUtil.EMPTY_CHAR_SEQUENCE!!
    private var bufStart = 0
    private var bufEnd = 0

    private var state = 0

    private var token: IElementType? = null
    private var tokenStart = 0
    private var tokenEnd = 0

    private var pos = 0

    /**
     * Determines the next token by using [avail], [curr], [skip] and [skipChar]
     * to skip over all parts of the token.
     * At the end, the token is built from exactly the skipped part.
     *
     * If needed, the lexer can remember its state using [getState] and [setState].
     * The lexer must not use any other state variables.
     */
    protected abstract fun nextToken(): IElementType

    /** Tests whether a current character is available. */
    protected val avail; get() = pos < bufEnd
    protected val curr; get() = buf[pos]

    /**
     * Tests whether the character at the current position equals
     * the given character and if so, skips over it.
     */
    protected fun skipChar(ch: Char): Boolean {
        val skipped = pos < bufEnd && buf[pos] == ch
        if (skipped) pos++
        return skipped
    }

    protected fun skip() = skip(1)
    protected fun skip(n: Int): Boolean {
        val skipped = pos + n < bufEnd
        if (skipped) pos += n
        return skipped
    }

    protected fun setState(state: Int) {
        this.state = state
    }

    override fun getState() = state

    override fun advance() {
        if (bufStart >= bufEnd) {
            tokenStart = bufStart
            tokenEnd = bufStart
            token = null
            return
        }

        pos = bufStart
        val token = nextToken()
        if (pos <= bufStart || pos > bufEnd) {
            throw AssertionError()
        }
        tokenStart = bufStart
        tokenEnd = pos
        this.token = token
        this.bufStart = pos
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buf = buffer
        bufEnd = endOffset
        bufStart = startOffset
        advance()
    }

    override fun getTokenType(): IElementType? = token
    override fun getTokenStart() = tokenStart
    override fun getTokenEnd() = tokenEnd
    override fun getBufferSequence() = buf
    override fun getBufferEnd() = bufEnd

    override fun getCurrentPosition(): LexerPosition = LexPos(tokenStart, state)

    override fun restore(position: LexerPosition) =
            start(bufferSequence, position.offset, bufferEnd, position.state)

    private class LexPos(
            private val offset: Int,
            private val state: Int) : LexerPosition {
        override fun getState() = state
        override fun getOffset() = offset
    }
}
