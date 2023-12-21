import React from 'react'
import { CiFacebook, CiInstagram } from 'react-icons/ci'
import { RiGithubFill } from "react-icons/ri";

const OpalRrss = () => {
    return (
        <div className='d-flex flex-column  justify-content-center align-items-center text-light pb-2 rrss-Opal'>
{/* https://web.facebook.com/    */}
            <div className=' text-uppercase fs-6  my-2'>
                <span className='mx-2 fw-normal'>síguenos en </span>
                <CiFacebook className='mx-1 fw-normal'/> 
                <CiInstagram className='mx-1 fw-normal'/>
                <RiGithubFill className='mx-1 fw-normal'/>
                <span className='mx-2 fw-normal' >#OPAL</span>
            </div>
            <small className='fw-normal'>Copyright © 2023 OPAL</small>
        </div>
    )
}

export default OpalRrss