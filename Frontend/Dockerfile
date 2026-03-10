# -------- Stage 1 : Build Angular --------
FROM node:20-alpine AS build

WORKDIR /app

# Copier les dépendances
COPY package*.json ./

# Installer les dépendances
RUN npm install

# Copier le reste du projet
COPY . .

# Build Angular
RUN npm run build

# -------- Stage 2 : Nginx --------
FROM nginx:alpine

# Copier le build Angular dans nginx
COPY --from=build /app/dist/client-commande-front/browser /usr/share/nginx/html

# Config nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80