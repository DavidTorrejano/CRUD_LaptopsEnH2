FROM ubuntu:latest
LABEL authors="davit"

ENTRYPOINT ["top", "-b"]