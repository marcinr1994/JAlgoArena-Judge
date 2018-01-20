FROM openjdk:8


ADD build/libs/jalgoarena-judge-*.jar /opt/jalgoarena-judge/jalgoarena-judge.jar

ENV EUREKA_URL=http://eureka:5000/eureka
EXPOSE 8080

ENTRYPOINT java -Dserver.port=8080 -classpath "lib/*" -jar /opt/jalgoarena-judge/jalgoarena-judge.jar