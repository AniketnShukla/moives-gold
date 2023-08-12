import './App.css';
import api from './API/axiosConfig';
import { useEffect, useState } from 'react';
import Layout from './Components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './Components/home/Home';
import Header from './Components/header/Header';
import Trailer from './Components/trailer/Trailer';
import Reviews from './Components/reviews/Reviews';
import NotFound from './Components/notFound/NotFound';

function App() {

  const [movies, setMovies] = useState([]);
  const [movie, setMovie] = useState('');
  const [reviews, setReviews] = useState([]);

  
  const getMovies = async () => {
    try{
      const response = await api.get("/api/v1/movies");
      
      console.log(response.data);
      console.log('ulululul')

      setMovies(response.data);
    }
    catch(err){
      console.log(err)
      console.log('ulululul')
    }
  }
  const getMovieData = async (movieId) => {
    try 
    {
      const response = await api.get(`/api/v1/movies/${movieId}`); 

      const singleMovie = response.data;
      // console.log(singleMovie)
      setMovie(singleMovie)
      setReviews(singleMovie.reviewIds)
    } 
    catch (error) 
    {
      console.log(error);
    }
  }
// 1 57 35
  useEffect(()=>{
    getMovies();
  },[])

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path = "/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies }/>} />      
          <Route path="/Trailer/:ytTrailerId" element={<Trailer />} />      
          <Route path="/Reviews/:movieId" 
          element = 
            {
              <Reviews 
                getMovieData = {getMovieData} 
                movie={movie} 
                reviews = {reviews} 
                setReviews = {setReviews} 
              />
            }
          />      
        </Route>
        <Route path="*" element={<NotFound />}></Route>
      </Routes>
    </div>
  );
}

export default App;
