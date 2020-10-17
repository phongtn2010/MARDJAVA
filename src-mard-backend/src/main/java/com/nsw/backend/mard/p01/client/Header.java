package com.nsw.backend.mard.p01.client;

import lombok.Data;

@Data
public class Header {
    private From From;
    private From To;
    private Subject Subject;
}
