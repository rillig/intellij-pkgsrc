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

import java.util.HashMap;
import java.util.Map;

public class BsdMakefileSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey DIRECTIVE = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_DIRECTIVE",
            DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey OTHER = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_OTHER",
            HighlighterColors.TEXT);


    private static final Map<IElementType, TextAttributesKey[]> map = new ColorMapperBuilder()
            .put(BsdMakefileTypes.COMMENT_START, COMMENT)
            .put(BsdMakefileTypes.COMMENT, COMMENT)
            .put(BsdMakefileTypes.OTHER, OTHER)
            .put(BsdMakefileTypes.DIRECTIVE, DIRECTIVE)
            .build();

    private static final TextAttributesKey[] NONE = {};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new BsdMakefileLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return map.getOrDefault(tokenType, NONE);
    }

    private static class ColorMapperBuilder {
        private final Map<IElementType, TextAttributesKey[]> result = new HashMap<>();

        ColorMapperBuilder put(IElementType tokenType, TextAttributesKey key) {
            result.put(tokenType, new TextAttributesKey[]{key});
            return this;
        }

        Map<IElementType, TextAttributesKey[]> build() {
            return result;
        }
    }
}
