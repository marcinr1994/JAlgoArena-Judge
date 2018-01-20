FROM openjdk:8

WORKDIR /opt/jalgoarena-judge
ADD build/libs/jalgoarena-judge-*.jar /opt/jalgoarena-judge

ENV EUREKA_URL=http://eureka:5000/eureka
EXPOSE 8080

CMD java -Dserver.port=8080 -classpath "lib/*" -jar /opt/jalgoarena-judge/jalgoarena-judge-*.jar