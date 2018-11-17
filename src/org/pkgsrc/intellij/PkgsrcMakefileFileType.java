package org.pkgsrc.intellij;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PkgsrcMakefileFileType extends LanguageFileType {

    public static final LanguageFileType INSTANCE = new PkgsrcMakefileFileType();

    private PkgsrcMakefileFileType() {
        super(PkgsrcLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Pkgsrc Makefile fragment";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "A fragment of a Makefile included by a pkgsrc package or other fragments";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "mk";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PkgsrcIcons.MAKEFILE_FRAGMENT;
    }
}
