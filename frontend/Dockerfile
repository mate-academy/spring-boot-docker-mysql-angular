FROM node:16
WORKDIR /usr/src/app
COPY package.json .
RUN npm i -g @angular/cli@13.1.4
RUN npm i
COPY . .
CMD ng serve --host 0.0.0.0
