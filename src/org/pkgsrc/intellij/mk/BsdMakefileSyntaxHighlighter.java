package org.pkgsrc.intellij.mk;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.pkgsrc.intellij.mk.parser.BsdMakefileLexerAdapter;
import org.pkgsrc.intellij.mk.psi.BsdMakefileTypes;

public class BsdMakefileSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey OTHER = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_OTHER",
            HighlighterColors.TEXT);

    private static final TextAttributesKey[] COMMENTS = {COMMENT};
    private static final TextAttributesKey[] OTHERS = {OTHER};
    private static final TextAttributesKey[] EMPTIES = {};


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new BsdMakefileLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(BsdMakefileTypes.COMMENT_START) || tokenType.equals(BsdMakefileTypes.COMMENT)) {
            return COMMENTS;
        } else if (tokenType.equals(BsdMakefileTypes.OTHER)) {
            return OTHERS;
        } else {
            return EMPTIES;
        }
    }
}
