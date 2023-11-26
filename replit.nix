{ pkgs }: {
    deps = [
        pkgs.graalvm17-ce
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
        pkgs.astyle
        pkgs.gfortran
        pkgs.ruby
        pkgs.python3
        pkgs.openjdk
        pkgs.gnu-cobol
        pkgs.dotnet-sdk_7
    ];
}