FROM openjdk:11
EXPOSE 8099
COPY target/*.war 20220414_Boot_JS.war
ENTRYPOINT ["java","-jar","20220414_Boot_JS.war"]

#FROM 설치 환경 ex) openjdk:11
#EXPOSE Container가 실행시 연결하 내부 포트
#COPY 파일을 ex) SpringBoot_Docker > target > *.war 복사해 보겠다 
#ENTRYPOINT 컨테이너가 실행될때 먼저 실행하는 명령어 배열 ex) java -jar ~~.war