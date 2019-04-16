// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_plot;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

import static org.bytedeco.opencv.global.opencv_plot.*;

    /** \addtogroup plot
     *  \{ */

        @Namespace("cv::plot") @Properties(inherit = org.bytedeco.opencv.presets.opencv_plot.class)
public class Plot2d extends Algorithm {
            static { Loader.load(); }
            /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
            public Plot2d(Pointer p) { super(p); }
        

            public native void setMinX(double _plotMinX);
            public native void setMinY(double _plotMinY);
            public native void setMaxX(double _plotMaxX);
            public native void setMaxY(double _plotMaxY);
            public native void setPlotLineWidth(int _plotLineWidth);
            /**
             * \brief Switches data visualization mode
             *
             * @param _needPlotLine if true then neighbour plot points will be connected by lines.
             * In other case data will be plotted as a set of standalone points.
             */
            public native void setNeedPlotLine(@Cast("bool") boolean _needPlotLine);
            public native void setPlotLineColor(@ByVal Scalar _plotLineColor);
            public native void setPlotBackgroundColor(@ByVal Scalar _plotBackgroundColor);
            public native void setPlotAxisColor(@ByVal Scalar _plotAxisColor);
            public native void setPlotGridColor(@ByVal Scalar _plotGridColor);
            public native void setPlotTextColor(@ByVal Scalar _plotTextColor);
            public native void setPlotSize(int _plotSizeWidth, int _plotSizeHeight);
            public native void setShowGrid(@Cast("bool") boolean needShowGrid);
            public native void setShowText(@Cast("bool") boolean needShowText);
            public native void setGridLinesNumber(int gridLinesNumber);
            public native void setInvertOrientation(@Cast("bool") boolean _invertOrientation);
            /**
             * \brief Sets the index of a point which coordinates will be printed on the top left corner of the plot (if ShowText flag is true).
             *
             * @param pointIdx index of the required point in data array.
             */
            public native void setPointIdxToPrint(int pointIdx);
            public native void render(@ByVal Mat _plotResult);
            public native void render(@ByVal UMat _plotResult);
            public native void render(@ByVal GpuMat _plotResult);

            /**
             * \brief Creates Plot2d object
             *
             * @param data {@code 1xN} or {@code Nx1} matrix containing {@code Y} values of points to plot. {@code X} values
             * will be equal to indexes of correspondind elements in data matrix.
             */
            public static native @Ptr Plot2d create(@ByVal Mat data);
            public static native @Ptr Plot2d create(@ByVal UMat data);
            public static native @Ptr Plot2d create(@ByVal GpuMat data);

            /**
             * \brief Creates Plot2d object
             *
             * @param dataX {@code 1xN} or {@code Nx1} matrix {@code X} values of points to plot.
             * @param dataY {@code 1xN} or {@code Nx1} matrix containing {@code Y} values of points to plot.
             */
            public static native @Ptr Plot2d create(@ByVal Mat dataX, @ByVal Mat dataY);
            public static native @Ptr Plot2d create(@ByVal UMat dataX, @ByVal UMat dataY);
            public static native @Ptr Plot2d create(@ByVal GpuMat dataX, @ByVal GpuMat dataY);
        }
