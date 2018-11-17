package org.pkgsrc.intellij.mk;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;

public interface BsdMakefileColors {

    TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);

    TextAttributesKey DIRECTIVE = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_DIRECTIVE",
            DefaultLanguageHighlighterColors.KEYWORD);

    TextAttributesKey SHELL = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_SHELL",
            DefaultLanguageHighlighterColors.FUNCTION_CALL);

    TextAttributesKey MKVARDEF = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_MKVARDEF",
            DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);

    TextAttributesKey MKVARUSE = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_MKVARUSE",
            DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);

    TextAttributesKey SHVARDEF = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_SHVARDEF",
            DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    TextAttributesKey SHVARUSE = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_SHVARUSE",
            DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    TextAttributesKey OTHER = TextAttributesKey.createTextAttributesKey(
            "BSD_MAKE_TEXT",
            HighlighterColors.TEXT);

    AttributesDescriptor[] DESCRIPTORS = {
            new AttributesDescriptor("Comment", COMMENT),
            new AttributesDescriptor("Directive", DIRECTIVE),
            new AttributesDescriptor("Shell command", SHELL),
            new AttributesDescriptor("Makefile variable definition", MKVARDEF),
            new AttributesDescriptor("Makefile variable use", MKVARUSE),
            new AttributesDescriptor("Shell variable definition", SHVARDEF),
            new AttributesDescriptor("Shell variable use", SHVARUSE),
            new AttributesDescriptor("Other", OTHER)};

}
