// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.caffe;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.hdf5.*;
import static org.bytedeco.hdf5.global.hdf5.*;

import static org.bytedeco.caffe.global.caffe.*;

@Name("caffe::HDF5DataLayer<double>") @NoOffset @Properties(inherit = org.bytedeco.caffe.presets.caffe.class)
public class DoubleHDF5DataLayer extends DoubleLayer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DoubleHDF5DataLayer(Pointer p) { super(p); }

  public DoubleHDF5DataLayer(@Const @ByRef LayerParameter param) { super((Pointer)null); allocate(param); }
  private native void allocate(@Const @ByRef LayerParameter param);
  @Virtual public native void LayerSetUp(@Const @ByRef DoubleBlobVector bottom,
        @Const @ByRef DoubleBlobVector top);
  // Data layers have no bottoms, so reshaping is trivial.
  @Virtual public native void Reshape(@Const @ByRef DoubleBlobVector bottom,
        @Const @ByRef DoubleBlobVector top);

  @Virtual public native @Const({false, false, true}) @Cast("const char*") BytePointer type();
  @Virtual public native @Const({false, false, true}) int ExactNumBottomBlobs();
  @Virtual public native @Const({false, false, true}) int MinTopBlobs();

  @Virtual protected native void Forward_cpu(@Const @ByRef DoubleBlobVector bottom,
        @Const @ByRef DoubleBlobVector top);
  @Virtual protected native void Forward_gpu(@Const @ByRef DoubleBlobVector bottom,
        @Const @ByRef DoubleBlobVector top);
  @Virtual protected native void Backward_cpu(@Const @ByRef DoubleBlobVector top,
        @Const @ByRef BoolVector propagate_down, @Const @ByRef DoubleBlobVector bottom);
  @Virtual protected native void Backward_gpu(@Const @ByRef DoubleBlobVector top,
        @Const @ByRef BoolVector propagate_down, @Const @ByRef DoubleBlobVector bottom);
  @Virtual protected native void LoadHDF5FileData(@Cast("const char*") BytePointer filename);
}
