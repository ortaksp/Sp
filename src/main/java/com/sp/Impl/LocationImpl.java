/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.Impl;

import com.sp.entity.Location;


public class LocationImpl extends Location {

    public LocationImpl() {
    }

    public LocationImpl(Integer locationid) {
        super(locationid);
    }

    public LocationImpl(Integer locationid, String country, String area, String city) {
        super(locationid, country, area, city);
    }
    
}
