package org.pkgsrc.intellij.mk.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.pkgsrc.intellij.PkgsrcFileTypes;
import org.pkgsrc.intellij.PkgsrcLanguages;

public class BsdMakefileFile extends PsiFileBase {

    public BsdMakefileFile(FileViewProvider viewProvider) {
        super(viewProvider, PkgsrcLanguages.MAKEFILE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return PkgsrcFileTypes.MAKEFILE_FRAGMENT; // TODO
    }

    @Override
    public String toString() {
        return getFileType().getName();
    }
}
