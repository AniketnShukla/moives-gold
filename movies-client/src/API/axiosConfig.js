import axios from 'axios';

// Note the settings included here, 
// we have the baseURL setting, which provides the base address of the API endpoints that our client react application will be calling 
// When we use Axios to call an endpoint, we won't be needing to repeat the base URL with each HTTP request wihtin our code,
// We will only need to include the additional path informtation required to target a specific endpoint    
// if this isnt clear -> baseURL: 'https://9c96-103-106-239-104.ap,ngrok.io <- it will become clear when we write code to make a HTTP request to the relevant remote endpoint. This setting is necessary Because during the development phase the technology that the remote machine is using to expose the relevant API endpoints is called ngrok Check specidics ngrok But we need to include this setting inn order for our client HTTP requiests to not be nlocked by CORS 
// Check details of CORS -> Cross Origin Resource Sharing, All we need to know is because the relevant web API is running on a different domain, or origin, CORS may block access to the endpoint. The server code has included settings in order to overcome the restrictions impsed by cors and we are including the headers settings so that we can overcome the restrictions imposed by cors that is so that we are able to access the resources made available through the relevant API endpoints 
 export default axios.create({
    baseURL: 'https://fa52-122-171-22-144.ngrok-free.app',
    // baseURL: 'http://localhost:8080',
    headers: {"ngrok-skip-browser-warning": "true"}
 });