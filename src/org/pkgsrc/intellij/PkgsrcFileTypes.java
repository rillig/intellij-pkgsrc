package org.pkgsrc.intellij;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.fileTypes.FileNameMatcherFactory;

import javax.swing.*;

public class PkgsrcFileTypes extends FileTypeFactory {

    public static final  FileType PACKAGE_MAKEFILE = new SimpleFileType(
            PkgsrcLanguages.MAKEFILE,
            "Pkgsrc package definition",
            "Central definition of a pkgsrc package containing instructions for building the package",
            "",
            PkgsrcIcons.PACKAGE);

    public static final  FileType MAKEFILE_FRAGMENT = new SimpleFileType(
            PkgsrcLanguages.MAKEFILE,
            "Pkgsrc Makefile fragment",
            "A fragment of a Makefile included by a pkgsrc package or other fragments",
            "mk",
            PkgsrcIcons.MAKEFILE_FRAGMENT);

    public static final  FileType DISTINFO = new SimpleFileType(
            PkgsrcLanguages.DISTINFO,
            "Pkgsrc file checksums",
            "Contains checksums for downloaded files and patches",
            "",
            PkgsrcIcons.OTHER);

    public static final  FileType PLIST = new SimpleFileType(
            PkgsrcLanguages.PLIST,
            "Pkgsrc packing list",
            "Contains the list of files installed by the package",
            "",
            PkgsrcIcons.OTHER);

    public static final  FileType PATCH = new SimpleFileType(
            PkgsrcLanguages.PATCH,
            "Pkgsrc patch",
            "Patches a file from the original downloaded package",
            "",
            PkgsrcIcons.OTHER);

    public static final  FileType DESCR = new SimpleFileType(
            PkgsrcLanguages.DESCR,
            "Pkgsrc package description",
            "Describes a pkgsrc package in about 20 lines of text",
            "",
            PkgsrcIcons.OTHER);

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        FileNameMatcherFactory mf = FileNameMatcherFactory.getInstance();

        consumer.consume(PACKAGE_MAKEFILE, mf.createMatcher("Makefile"));
        consumer.consume(MAKEFILE_FRAGMENT, mf.createMatcher("Makefile.*"));
        consumer.consume(MAKEFILE_FRAGMENT, mf.createMatcher("*.mk"));
        consumer.consume(DISTINFO, mf.createMatcher("distinfo"));
        consumer.consume(DESCR, mf.createMatcher("DESCR"));
        consumer.consume(DESCR, mf.createMatcher("DESCR.*"));
        consumer.consume(PLIST, mf.createMatcher("PLIST"));
        consumer.consume(PLIST, mf.createMatcher("PLIST.*"));
        consumer.consume(PLIST, mf.createMatcher("patch-*"));
    }

    private static class SimpleFileType extends LanguageFileType {

        private final String name;
        private final String description;
        private final String defaultExtension;
        private final Icon icon;

        SimpleFileType(Language language, String name, String description, String defaultExtension, Icon icon) {
            super(language);
            this.name = name;
            this.description = description;
            this.defaultExtension = defaultExtension;
            this.icon = icon;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }

        @NotNull
        @Override
        public String getDescription() {
            return description;
        }

        @NotNull
        @Override
        public String getDefaultExtension() {
            return defaultExtension;
        }

        @Nullable
        @Override
        public Icon getIcon() {
            return icon;
        }
    }
}
