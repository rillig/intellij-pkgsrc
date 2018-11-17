package org.pkgsrc.intellij.mk;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pkgsrc.intellij.PkgsrcFileTypes;
import org.pkgsrc.intellij.PkgsrcIcons;

import javax.swing.*;
import java.util.Map;

public class BsdMakefileColorSettingsPage implements ColorSettingsPage {

    @Nullable
    @Override
    public Icon getIcon() {
        return PkgsrcIcons.MAKEFILE_FRAGMENT;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new BsdMakefileSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "" +
                "# $NetBSD$\n" +
                "#\n" +
                "\n" +
                "VARNAME=\t\tVariable ${VALUE}\n" +
                ".if defined(VARNAME)\n" +
                "pre-configure:\n" +
                "\t${RUN} shell-command $$shell_variable\n" +
                ".endif\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return BsdMakefileColors.DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return PkgsrcFileTypes.MAKEFILE_FRAGMENT.getName();
    }
}
