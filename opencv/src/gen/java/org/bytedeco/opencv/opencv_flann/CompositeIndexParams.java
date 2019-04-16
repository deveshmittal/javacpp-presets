// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_flann;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;

import static org.bytedeco.opencv.global.opencv_flann.*;


@Namespace("cv::flann") @Properties(inherit = org.bytedeco.opencv.presets.opencv_flann.class)
public class CompositeIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CompositeIndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CompositeIndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public CompositeIndexParams position(long position) {
        return (CompositeIndexParams)super.position(position);
    }

    public CompositeIndexParams(int trees/*=4*/, int branching/*=32*/, int iterations/*=11*/,
                             @Cast("cvflann::flann_centers_init_t") int centers_init/*=cvflann::FLANN_CENTERS_RANDOM*/, float cb_index/*=0.2f*/ ) { super((Pointer)null); allocate(trees, branching, iterations, centers_init, cb_index); }
    private native void allocate(int trees/*=4*/, int branching/*=32*/, int iterations/*=11*/,
                             @Cast("cvflann::flann_centers_init_t") int centers_init/*=cvflann::FLANN_CENTERS_RANDOM*/, float cb_index/*=0.2f*/ );
    public CompositeIndexParams( ) { super((Pointer)null); allocate(); }
    private native void allocate( );
}
