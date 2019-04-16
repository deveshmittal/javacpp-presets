// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.global;

import org.bytedeco.opencv.opencv_shape.*;

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
import org.bytedeco.opencv.opencv_flann.*;
import static org.bytedeco.opencv.global.opencv_flann.*;
import org.bytedeco.opencv.opencv_features2d.*;
import static org.bytedeco.opencv.global.opencv_features2d.*;
import org.bytedeco.opencv.opencv_calib3d.*;
import static org.bytedeco.opencv.global.opencv_calib3d.*;

public class opencv_shape extends org.bytedeco.opencv.presets.opencv_shape {
    static { Loader.load(); }

// Parsed from <opencv2/shape.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2012, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef OPENCV_SHAPE_HPP
// #define OPENCV_SHAPE_HPP

// #include "opencv2/shape/emdL1.hpp"
// #include "opencv2/shape/shape_transformer.hpp"
// #include "opencv2/shape/hist_cost.hpp"
// #include "opencv2/shape/shape_distance.hpp"

/**
  \defgroup shape Shape Distance and Matching
 */

// #endif

/* End of file. */


// Parsed from <opencv2/shape/emdL1.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2012, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef OPENCV_EMD_L1_HPP
// #define OPENCV_EMD_L1_HPP

// #include "opencv2/core.hpp"
/****************************************************************************************\
*                                   EMDL1 Function                                      *
\****************************************************************************************/

/** \addtogroup shape
/** \{
<p>
/** \brief Computes the "minimal work" distance between two weighted point configurations base on the papers
"EMD-L1: An efficient and Robust Algorithm for comparing histogram-based descriptors", by Haibin
Ling and Kazunori Okuda; and "The Earth Mover's Distance is the Mallows Distance: Some Insights from
Statistics", by Elizaveta Levina and Peter Bickel.
<p>
@param signature1 First signature, a single column floating-point matrix. Each row is the value of
the histogram in each bin.
@param signature2 Second signature of the same format and size as signature1.
 */
@Namespace("cv") public static native float EMDL1(@ByVal Mat signature1, @ByVal Mat signature2);
@Namespace("cv") public static native float EMDL1(@ByVal UMat signature1, @ByVal UMat signature2);
@Namespace("cv") public static native float EMDL1(@ByVal GpuMat signature1, @ByVal GpuMat signature2);

/** \} */

//namespace cv

// #endif


// Parsed from <opencv2/shape/shape_transformer.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                          License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Copyright (C) 2013, OpenCV Foundation, all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef OPENCV_SHAPE_SHAPE_TRANSFORM_HPP
// #define OPENCV_SHAPE_SHAPE_TRANSFORM_HPP
// #include <vector>
// #include "opencv2/core.hpp"
// #include "opencv2/imgproc.hpp"
// Targeting ../opencv_shape/ShapeTransformer.java


// Targeting ../opencv_shape/ThinPlateSplineShapeTransformer.java



/** Complete constructor */
@Namespace("cv") public static native @Ptr ThinPlateSplineShapeTransformer createThinPlateSplineShapeTransformer(double regularizationParameter/*=0*/);
@Namespace("cv") public static native @Ptr ThinPlateSplineShapeTransformer createThinPlateSplineShapeTransformer();
// Targeting ../opencv_shape/AffineTransformer.java



/** Complete constructor */
@Namespace("cv") public static native @Ptr AffineTransformer createAffineTransformer(@Cast("bool") boolean fullAffine);

/** \} */

 // cv
// #endif


// Parsed from <opencv2/shape/hist_cost.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                          License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Copyright (C) 2013, OpenCV Foundation, all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef OPENCV_HIST_COST_HPP
// #define OPENCV_HIST_COST_HPP

// #include "opencv2/imgproc.hpp"
// Targeting ../opencv_shape/HistogramCostExtractor.java


// Targeting ../opencv_shape/NormHistogramCostExtractor.java



@Namespace("cv") public static native @Ptr HistogramCostExtractor createNormHistogramCostExtractor(int flag/*=cv::DIST_L2*/, int nDummies/*=25*/, float defaultCost/*=0.2f*/);
@Namespace("cv") public static native @Ptr HistogramCostExtractor createNormHistogramCostExtractor();
// Targeting ../opencv_shape/EMDHistogramCostExtractor.java



@Namespace("cv") public static native @Ptr HistogramCostExtractor createEMDHistogramCostExtractor(int flag/*=cv::DIST_L2*/, int nDummies/*=25*/, float defaultCost/*=0.2f*/);
@Namespace("cv") public static native @Ptr HistogramCostExtractor createEMDHistogramCostExtractor();
// Targeting ../opencv_shape/ChiHistogramCostExtractor.java



@Namespace("cv") public static native @Ptr HistogramCostExtractor createChiHistogramCostExtractor(int nDummies/*=25*/, float defaultCost/*=0.2f*/);
@Namespace("cv") public static native @Ptr HistogramCostExtractor createChiHistogramCostExtractor();
// Targeting ../opencv_shape/EMDL1HistogramCostExtractor.java



@Namespace("cv") public static native @Ptr HistogramCostExtractor createEMDL1HistogramCostExtractor(int nDummies/*=25*/, float defaultCost/*=0.2f*/);
@Namespace("cv") public static native @Ptr HistogramCostExtractor createEMDL1HistogramCostExtractor();

/** \} */

 // cv
// #endif


// Parsed from <opencv2/shape/shape_distance.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                          License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Copyright (C) 2013, OpenCV Foundation, all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef OPENCV_SHAPE_SHAPE_DISTANCE_HPP
// #define OPENCV_SHAPE_SHAPE_DISTANCE_HPP
// #include "opencv2/core.hpp"
// #include "opencv2/shape/hist_cost.hpp"
// #include "opencv2/shape/shape_transformer.hpp"
// Targeting ../opencv_shape/ShapeDistanceExtractor.java


// Targeting ../opencv_shape/ShapeContextDistanceExtractor.java



/* Complete constructor */
@Namespace("cv") public static native @Ptr ShapeContextDistanceExtractor createShapeContextDistanceExtractor(int nAngularBins/*=12*/, int nRadialBins/*=4*/,
                                        float innerRadius/*=0.2f*/, float outerRadius/*=2*/, int iterations/*=3*/,
                                        @Ptr HistogramCostExtractor comparer/*=createChiHistogramCostExtractor()*/,
                                        @Ptr ShapeTransformer transformer/*=createThinPlateSplineShapeTransformer()*/);
@Namespace("cv") public static native @Ptr ShapeContextDistanceExtractor createShapeContextDistanceExtractor();
// Targeting ../opencv_shape/HausdorffDistanceExtractor.java



/* Constructor */
@Namespace("cv") public static native @Ptr HausdorffDistanceExtractor createHausdorffDistanceExtractor(int distanceFlag/*=cv::NORM_L2*/, float rankProp/*=0.6f*/);
@Namespace("cv") public static native @Ptr HausdorffDistanceExtractor createHausdorffDistanceExtractor();

/** \} */

 // cv
// #endif


}
