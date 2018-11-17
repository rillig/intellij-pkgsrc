package org.pkgsrc.intellij;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PkgsrcPackageFileType extends LanguageFileType {

    public static final LanguageFileType INSTANCE = new PkgsrcPackageFileType();

    private PkgsrcPackageFileType() {
        super(PkgsrcLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Pkgsrc package definition";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Central definition of a pkgsrc package containing instructions for building the package";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PkgsrcIcons.PACKAGE;
    }
}
