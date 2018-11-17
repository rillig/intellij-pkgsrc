package org.pkgsrc.intellij.mk;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.pkgsrc.intellij.mk.parser.BsdMakefileLexer;
import org.pkgsrc.intellij.mk.psi.BsdMakefileTypes;

import java.util.HashMap;
import java.util.Map;

public class BsdMakefileSyntaxHighlighter extends SyntaxHighlighterBase {


    private static final Map<IElementType, TextAttributesKey[]> map = new ColorMapperBuilder()
            .put(BsdMakefileTypes.T_COMMENT_LINE, BsdMakefileColors.COMMENT)
            .put(BsdMakefileTypes.T_DIRECTIVE_LINE, BsdMakefileColors.DIRECTIVE)
            .put(BsdMakefileTypes.T_SHELL_LINE, BsdMakefileColors.SHELL)
            .put(BsdMakefileTypes.T_OTHER_LINE, BsdMakefileColors.OTHER)
            .put(BsdMakefileTypes.T_EMPTY_LINE, BsdMakefileColors.OTHER)
            .build();

    private static final TextAttributesKey[] NONE = {};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new BsdMakefileLexer();
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
