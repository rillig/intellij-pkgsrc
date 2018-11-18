package org.pkgsrc.intellij.mk.parser

import com.intellij.psi.tree.IElementType
import org.pkgsrc.intellij.mk.psi.BsdMakefileTypes
import org.pkgsrc.intellij.util.SkipLexer

// If the BsdMakefileTypes above cannot be found, open BsdMakefile.bnf
// and press Ctrl+Shift+G to generate the parser code.
// And if that doesn't work, install the Grammar-Kit plugin first.

class BsdMakefileLexer : SkipLexer() {

    override fun nextToken(): IElementType {
        if (skipChar('\n')) {
            return BsdMakefileTypes.T_EMPTY_LINE
        }
        return when {
            skipChar('#') -> let { skipLine(); BsdMakefileTypes.T_COMMENT_LINE }
            skipChar('.') -> let { skipLine(); BsdMakefileTypes.T_DIRECTIVE_LINE }
            skipChar('\t') -> let { skipLine(); BsdMakefileTypes.T_SHELL_LINE }
            else -> let { skipLine(); BsdMakefileTypes.T_OTHER_LINE }
        }
    }

    private fun skipLine() {
        while (avail && curr != '\n') {
            if (curr == '\\') skip()
            skip()
        }
        if (avail) skip()
    }
}
