FROM nginx
WORKDIR /usr/share/nginx/html
ADD frontend/ .
EXPOSE 80