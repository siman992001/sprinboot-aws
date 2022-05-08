FROM public.ecr.aws/docker/library/openjdk:17
ARG JAR_FILE=/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]