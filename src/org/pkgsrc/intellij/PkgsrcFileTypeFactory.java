package org.pkgsrc.intellij;

import com.intellij.openapi.fileTypes.ExactFileNameMatcher;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class PkgsrcFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(PkgsrcPackageFileType.INSTANCE, new ExactFileNameMatcher("Makefile", false));
        consumer.consume(PkgsrcMakefileFileType.INSTANCE);
    }
}
