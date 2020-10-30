# HelloWorldDeluxe


This project is meant to showcase all kinds of frameworks, tooling and other technical jargon that is used in the programming world.

<h2>How to run with Docker</h2>
<ol>
  <li>In {root}/src/main/HelloWorldDeluxe build frontend application: ng build --prod</li>
  <li>In root directory build backend application: mvn install -DskipTests</li>
  <li>In root directory build backend image: docker build -f backend.df -t bschaaf/hello-backend:0.1 .</li>
  <li>In root directory build frontend image: docker build -f frontend.df -t bschaaf/hello-frontend:0.1 .</li>
  <li>In root directory start database, backend en frontend: docker-compose -f hello.yml up</li>
  <li>Application is available at http://localhost:90</li>
</ol>

<h2>How to run the frontend in development</h2>
<ol>
  <li>Install <a href="https://nodejs.org/en/download/">Nodejs</a></li>
  <li>Clone this repo and navigate to "src/main/HelloWorldDeluxe" within the project using a terminal of your choice</li>
  <li>Run 'npm install'</li>
  <li>Navigate to "proxy.conf.json" and change the port on both 'target' and 'pathRewrite' to match the port on which the backend is running</li>
  <li>Run "npm start" in the console</li>
  <li>Open your browser and naviage to <a href="http://localhost:4200/">http://localhost:4200/</a></li>
</ol>

