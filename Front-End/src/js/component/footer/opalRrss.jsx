import React from 'react'
import { CiFacebook, CiInstagram, CiTwitter } from 'react-icons/ci'

const OpalRrss = () => {
    return (
        <div className='d-flex flex-column fw-lighter justify-content-center align-items-center text-light pb-2 rrss-Opal'>

            <div className=' text-uppercase fs-6 fw-lighter my-2'>
                <span className='mx-2'>síguenos en </span>
                <CiFacebook className='mx-1'/>
                <CiInstagram className='mx-1'/>
                <CiTwitter className='mx-1'/>
                <span className='mx-2'>#OPAL</span>
            </div>
            <small>Copyright © 2023 OPAL</small>
        </div>
    )
}

export default OpalRrss