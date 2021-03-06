/**
 * Copyright (c) 2013, Anthony Schiochet and Eric Citaire
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * The names Anthony Schiochet and Eric Citaire may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL MICHAEL BOSTOCK BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/**
 * 
 */
package com.github.gwtd3.demo.client.democases;

import com.github.gwtd3.api.D3;
import com.github.gwtd3.api.JsArrays;
import com.github.gwtd3.api.core.Datum;
import com.github.gwtd3.api.core.Selection;
import com.github.gwtd3.api.functions.DatumFunction;
import com.github.gwtd3.demo.client.DemoCase;
import com.github.gwtd3.demo.client.Factory;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * @author <a href="mailto:schiochetanthoni@gmail.com">Anthony Schiochet</a>
 * 
 */
public class StupidExample extends FlowPanel implements DemoCase {

    private Selection svg;

    /**
	 * 
	 */
    public StupidExample() {
        super();
    }

    @Override
    public void start() {
        Selection selection = D3.select(this);

        int w = 960;
        int h = 800;
        svg = selection.append("svg:svg").attr("width", w).attr("height", h)
                .append("svg:g").attr("transform", "translate(40,0)");

        svg.selectAll("circle").data(JsArrays.asJsArray(32, 57, 112, 293))
                .enter()
                .append("circle")
                .attr("cy", 90)
                .attr("cx", new DatumFunction<Integer>() {
                    @Override
                    public Integer apply(final Element context, final Datum d, final int index) {
                        return d.asInt();
                    }
                })// String
                .attr("r", new DatumFunction<Double>() {
                    @Override
                    public Double apply(final Element context, final Datum d, final int index) {
                        return Math.sqrt(d.asDouble());
                    }
                });// sqrt

        svg.selectAll("circle").data(JsArrays.asJsArray(12, 32, 44))
                .enter().append("circle")
                .attr("cy", 90)
                .attr("cx", new DatumFunction<Integer>() {
                    @Override
                    public Integer apply(final Element context, final Datum d, final int index) {
                        return d.asInt();
                    }
                })// String
                .attr("r", new DatumFunction<Double>() {
                    @Override
                    public Double apply(final Element context, final Datum d, final int index) {
                        return Math.sqrt(d.asDouble());
                    }
                });// sqrt

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.github.gwtd3.demo.client.D3Demo#stop()
     */
    @Override
    public void stop() {
        svg = null;

    }

    public static Factory factory() {
        return new Factory() {
            @Override
            public DemoCase newInstance() {
                return new StupidExample();
            }
        };
    }
}
