package com.nsw.backend.mard.p06.client;

import lombok.Data;

@Data
public class Header {
    private From from;
    private From to;
    private Subject subject;
}
