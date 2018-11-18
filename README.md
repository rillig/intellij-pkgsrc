This [IntelliJ](https://www.jetbrains.com/idea/) plugin provides
very basic and very limited support for developing [pkgsrc](https://www.pkgsrc.org/) packages.

Currently implemented is:

* icons for pkgsrc-specific files
* in Makefiles, complete lines are highlighted

NOT yet implemented is everything else you might expect from a proper IntelliJ plugin, such as:

* inspections like those provided by [pkglint](https://github.com/rillig/pkglint/)
* highlighting for smaller units than whole lines
* intentions for common tasks:
    * adding a dependency
    * updating a package definition to the latest version
    * installing a package locally
* highlighting for distinfo
* highlighting for PLIST
* highlighting for patches
* navigation between packages
* navigation in Makefile editor
    * Ctrl+click or F4 to go to a variable definition
    * Alt+F7 to find usages of a variable
* structure view for Makefiles
* completion in Makefile editor
* quick documentation for variables in Makefiles
* visualization of a package's dependency graph
* automatic tests for all of the above items

If you want to implement one of the above features, feel free to do so.
