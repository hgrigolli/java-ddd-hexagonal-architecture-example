#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

public abstract class ${Operation}${Domain}UseCase extends NullaryUseCase<${OutputType}> {
}