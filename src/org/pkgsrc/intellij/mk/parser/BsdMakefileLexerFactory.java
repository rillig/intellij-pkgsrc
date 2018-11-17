package org.pkgsrc.intellij.mk.parser;

import com.google.common.collect.ImmutableList;
import com.intellij.ide.highlighter.custom.AbstractCustomLexer;
import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import org.pkgsrc.intellij.mk.psi.BsdMakefileTypes;

public class BsdMakefileLexerFactory {
    public static Lexer newLexer() {
        return new Lex();
    }

    private static class Lex extends AbstractCustomLexer {

        private int pos;

        Lex() {
            super(ImmutableList.of());
        }

        @Override
        public void advance() {
            if (myPosition >= myEndOffset) {
                myCurrentToken.updateData(myPosition, myPosition, null);
                return;
            }

            pos = myPosition;
            IElementType token = nextToken();
            if (token == null) {
                handleTokenNotFound();
                return;
            }
            if (pos <= myPosition || pos > myEndOffset) {
                throw new AssertionError();
            }
            myCurrentToken.updateData(myPosition, pos, token);

            this.myPosition = pos;
        }

        IElementType nextToken() {
            if (skip('\n')) {
                return BsdMakefileTypes.T_EMPTY_LINE;
            }
            if (skip('#')) {
                skipLine();
                return BsdMakefileTypes.T_COMMENT_LINE;
            }
            if (skip('.')) {
                skipLine();
                return BsdMakefileTypes.T_DIRECTIVE_LINE;
            }
            if (skip('\t')) {
                skipLine();
                return BsdMakefileTypes.T_SHELL_LINE;
            }

            skipLine();
            return BsdMakefileTypes.T_OTHER_LINE;
        }

        private boolean skip(int prefixCodePoint) {
            if (pos < myEndOffset && Character.codePointAt(myBuffer, pos) == prefixCodePoint) {
                pos += Character.charCount(prefixCodePoint);
                return true;
            }
            return false;
        }

        protected void skipLine() {
            while (pos < myEndOffset && myBuffer.charAt(pos) != '\n') {
                if (pos + 1 < myEndOffset && myBuffer.charAt(pos) == '\\') {
                    pos++;
                }
                pos++;
            }
            if (pos < myEndOffset) {
                pos++;
            }
        }
    }
}
