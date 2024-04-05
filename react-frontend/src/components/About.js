// About.js
import React from 'react';
import { HiCode } from "react-icons/hi";
import videoFile from '../assets/CupOfLemonTea.mp4';
import './css/About.css';

const About = () => {
     return (
          <div className="about-container">
               <div className="about-video">
                    <video autoPlay loop muted>
                         <source src={videoFile} type="video/mp4" />
                    </video>
               </div>
               <div className="about-content">
                    <h1><HiCode className="me-2" style={{ fontSize: "40px" }} />Tech Gurus</h1>
                    <p>Coder World is your go-to destination for all things coding. From beginner tutorials to advanced techniques, we've got you covered. Explore our comprehensive content library curated by experts, offering insights into programming languages, web development, software engineering, and more. Start your coding journey with us today!</p>
               </div>
          </div>
     );
};

export default About;
