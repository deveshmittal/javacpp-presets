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


@Name("caffe::DataLayer<float>") @NoOffset @Properties(inherit = org.bytedeco.caffe.presets.caffe.class)
public class FloatDataLayer extends FloatBasePrefetchingDataLayer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FloatDataLayer(Pointer p) { super(p); }

  public FloatDataLayer(@Const @ByRef LayerParameter param) { super((Pointer)null); allocate(param); }
  private native void allocate(@Const @ByRef LayerParameter param);
  @Virtual public native void DataLayerSetUp(@Const @ByRef FloatBlobVector bottom,
        @Const @ByRef FloatBlobVector top);
  @Virtual public native @Const({false, false, true}) @Cast("const char*") BytePointer type();
  @Virtual public native @Const({false, false, true}) int ExactNumBottomBlobs();
  @Virtual public native @Const({false, false, true}) int MinTopBlobs();
  @Virtual public native @Const({false, false, true}) int MaxTopBlobs();
  @Virtual protected native void load_batch(FloatBatch batch);
}
