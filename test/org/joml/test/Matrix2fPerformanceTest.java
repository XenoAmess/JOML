/*
 * The MIT License
 *
 * Copyright (c) 2019 JOML
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.joml.test;

import com.google.gwt.typedarrays.shared.Float32Array;
import junit.framework.TestCase;
import org.joml.Math;
import org.joml.*;
import org.joml.internal.Runtime;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

/**
 * Notice that this class is just created for proving using several floats is really faster than using a float array.
 * MUST NOT use it in real work.
 *
 * @author Joseph Burton
 * @author XenoAmess
 */
class Matrix2fx implements Externalizable {
    private static final void NIE() {
        throw new Error("NotImplementedException");
    }


    private static final long serialVersionUID = 1L;

    public float[] val = new float[4];

    /**
     * Create a new {@link Matrix2fx} and set it to {@link #identity() identity}.
     */
    public Matrix2fx() {
        val[0] = 1.0f;
        val[3] = 1.0f;
    }

    /**
     * Create a new {@link Matrix2fx} and make it a copy of the given matrix.
     *
     * @param mat the {@link Matrix2fx} to copy the values from
     */
    public Matrix2fx(Matrix2fx mat) {
        setMatrix2fx(mat);
    }

    /**
     * Create a new {@link Matrix2fx} and make it a copy of the upper left 2x2 of the given {@link Matrix3fc}.
     *
     * @param mat the {@link Matrix3fc} to copy the values from
     */
    public Matrix2fx(Matrix3fc mat) {
        setMatrix3fc(mat);
    }

    /**
     * Create a new 2x2 matrix using the supplied float values. The order of the parameter is column-major,
     * so the first two parameters specify the two elements of the first column.
     *
     * @param m00 the value of m00
     * @param m01 the value of m01
     * @param m10 the value of m10
     * @param m11 the value of m11
     */
    public Matrix2fx(float m00, float m01,
                     float m10, float m11) {
        this.val[0] = m00;
        this.val[1] = m01;
        this.val[2] = m10;
        this.val[3] = m11;
    }

//#ifdef __HAS_NIO__

    /**
     * Create a new {@link Matrix2fx} by reading its 4 float components from the given {@link FloatBuffer}
     * at the buffer's current position.
     * <p>
     * That FloatBuffer is expected to hold the values in column-major order.
     * <p>
     * The buffer's position will not be changed by this method.
     *
     * @param buffer the {@link FloatBuffer} to read the matrix values from
     */
    public Matrix2fx(FloatBuffer buffer) {
        NIE();
//        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
    }
//#endif

    /**
     * Create a new {@link Matrix2fx} and initialize its two columns using the supplied vectors.
     *
     * @param col0 the first column
     * @param col1 the second column
     */
    public Matrix2fx(Vector2fc col0, Vector2fc col1) {
        setVector2fc(col0, col1);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#m00
     */
    public float m00() {
        return val[0];
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#m01
     */
    public float m01() {
        return val[1];
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#m10
     */
    public float m10() {
        return val[2];
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#m11
     */
    public float m11() {
        return val[3];
    }

    /**
     * Set the value of the matrix element at column 0 and row 0.
     *
     * @param m00 the new value
     * @return this
     */
    public Matrix2fx m00(float m00) {
        this.val[0] = m00;
        return this;
    }

    /**
     * Set the value of the matrix element at column 0 and row 1.
     *
     * @param m01 the new value
     * @return this
     */
    public Matrix2fx m01(float m01) {
        this.val[1] = m01;
        return this;
    }

    /**
     * Set the value of the matrix element at column 1 and row 0.
     *
     * @param m10 the new value
     * @return this
     */
    public Matrix2fx m10(float m10) {
        this.val[2] = m10;
        return this;
    }

    /**
     * Set the value of the matrix element at column 1 and row 1.
     *
     * @param m11 the new value
     * @return this
     */
    public Matrix2fx m11(float m11) {
        this.val[3] = m11;
        return this;
    }

    /**
     * Set the value of the matrix element at column 0 and row 0.
     *
     * @param m00 the new value
     * @return this
     */
    public Matrix2fx _m00(float m00) {
        this.val[0] = m00;
        return this;
    }

    /**
     * Set the value of the matrix element at column 0 and row 1.
     *
     * @param m01 the new value
     * @return this
     */
    public Matrix2fx _m01(float m01) {
        this.val[1] = m01;
        return this;
    }

    /**
     * Set the value of the matrix element at column 1 and row 0.
     *
     * @param m10 the new value
     * @return this
     */
    public Matrix2fx _m10(float m10) {
        this.val[2] = m10;
        return this;
    }

    /**
     * Set the value of the matrix element at column 1 and row 1.
     *
     * @param m11 the new value
     * @return this
     */
    public Matrix2fx _m11(float m11) {
        this.val[3] = m11;
        return this;
    }

    /**
     * Set the elements of this matrix to the ones in <code>m</code>.
     *
     * @param m the matrix to copy the elements from
     * @return this
     */
    public Matrix2fx set(Matrix2fx m) {
        setMatrix2fx(m);
        return this;
    }

    private void setMatrix2fx(Matrix2fx mat) {
        System.arraycopy(mat.val, 0, this.val, 0, 4);
    }

    /**
     * Set the elements of this matrix to the left 2x2 submatrix of <code>m</code>.
     *
     * @param m the matrix to copy the elements from
     * @return this
     */
    public Matrix2fx set(Matrix3x2fc m) {
        setMatrix3x2fc(m);
        return this;
    }

    private void setMatrix3x2fc(Matrix3x2fc mat) {
        val[0] = mat.m00();
        val[1] = mat.m01();
        val[2] = mat.m10();
        val[3] = mat.m11();
    }

    /**
     * Set the elements of this matrix to the upper left 2x2 of the given {@link Matrix3fc}.
     *
     * @param m the {@link Matrix3fc} to copy the values from
     * @return this
     */
    public Matrix2fx set(Matrix3fc m) {
        setMatrix3fc(m);
        return this;
    }

    private void setMatrix3fc(Matrix3fc mat) {
        val[0] = mat.m00();
        val[1] = mat.m01();
        val[2] = mat.m10();
        val[3] = mat.m11();
    }

    /**
     * Multiply this matrix by the supplied <code>right</code> matrix.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the <code>right</code> matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * transformation of the right matrix will be applied first!
     *
     * @param right the right operand of the matrix multiplication
     * @return this
     */
    public Matrix2fx mul(Matrix2fx right) {
        return mul(right, this);
    }

    /*
     * (non-Javadoc)
     * @see org.joml.test.Matrix2fx#mul(org.joml.test.Matrix2fx, org.joml.test.Matrix2fx)
     */
    public Matrix2fx mul(Matrix2fx right, Matrix2fx dest) {
        float nm00 = val[0] * right.m00() + val[2] * right.m01();
        float nm01 = val[1] * right.m00() + val[3] * right.m01();
        float nm10 = val[0] * right.m10() + val[2] * right.m11();
        float nm11 = val[1] * right.m10() + val[3] * right.m11();
        dest.val[0] = nm00;
        dest.val[1] = nm01;
        dest.val[2] = nm10;
        dest.val[3] = nm11;
        return dest;
    }

    /**
     * Pre-multiply this matrix by the supplied <code>left</code> matrix and store the result in <code>this</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>L</code> the <code>left</code> matrix,
     * then the new matrix will be <code>L * M</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>L * M * v</code>, the
     * transformation of <code>this</code> matrix will be applied first!
     *
     * @param left the left operand of the matrix multiplication
     * @return this
     */
    public Matrix2fx mulLocal(Matrix2fx left) {
        return mulLocal(left, this);
    }

    /*
     * (non-Javadoc)
     * @see org.joml.test.Matrix2fx#mulLocal(org.joml.test.Matrix2fx, org.joml.test.Matrix2fx)
     */
    public Matrix2fx mulLocal(Matrix2fx left, Matrix2fx dest) {
        float nm00 = left.m00() * val[0] + left.m10() * val[1];
        float nm01 = left.m01() * val[0] + left.m11() * val[1];
        float nm10 = left.m00() * val[2] + left.m10() * val[3];
        float nm11 = left.m01() * val[2] + left.m11() * val[3];
        dest.val[0] = nm00;
        dest.val[1] = nm01;
        dest.val[2] = nm10;
        dest.val[3] = nm11;
        return dest;
    }

    /**
     * Set the values within this matrix to the supplied float values. The result looks like this:
     * <p>
     * m00, m10<br>
     * m01, m11<br>
     *
     * @param m00 the new value of m00
     * @param m01 the new value of m01
     * @param m10 the new value of m10
     * @param m11 the new value of m11
     * @return this
     */
    public Matrix2fx set(float m00, float m01,
                         float m10, float m11) {
        this.val[0] = m00;
        this.val[1] = m01;
        this.val[2] = m10;
        this.val[3] = m11;
        return this;
    }

    /**
     * Set the values in this matrix based on the supplied float array. The result looks like this:
     * <p>
     * 0, 2<br>
     * 1, 3<br>
     * <p>
     * This method only uses the first 4 values, all others are ignored.
     *
     * @param m the array to read the matrix values from
     * @return this
     */
    public Matrix2fx set(float m[]) {
        System.arraycopy(m, 0, val, 0, 4);
        return this;
    }

    /**
     * Set the two columns of this matrix to the supplied vectors, respectively.
     *
     * @param col0 the first column
     * @param col1 the second column
     * @return this
     */
    public Matrix2fx set(Vector2fc col0, Vector2fc col1) {
        setVector2fc(col0, col1);
        return this;
    }

    private void setVector2fc(Vector2fc col0, Vector2fc col1) {
        val[0] = col0.x();
        val[1] = col0.y();
        val[2] = col1.x();
        val[3] = col1.y();
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#determinant()
     */
    public float determinant() {
        return val[0] * val[3] - val[2] * val[1];
    }

    /**
     * Invert this matrix.
     *
     * @return this
     */
    public Matrix2fx invert() {
        return invert(this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#invert(org.joml.test.Matrix2fx)
     */
    public Matrix2fx invert(Matrix2fx dest) {
        float s = 1.0f / determinant();
        float nm00 = val[3] * s;
        float nm01 = -val[1] * s;
        float nm10 = -val[2] * s;
        float nm11 = val[0] * s;
        dest.val[0] = nm00;
        dest.val[1] = nm01;
        dest.val[2] = nm10;
        dest.val[3] = nm11;
        return dest;
    }

    /**
     * Transpose this matrix.
     *
     * @return this
     */
    public Matrix2fx transpose() {
        return transpose(this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#transpose(org.joml.test.Matrix2fx)
     */
    public Matrix2fx transpose(Matrix2fx dest) {
        dest.set(this);
        return dest;
    }

    /**
     * Return a string representation of this matrix.
     * <p>
     * This method creates a new {@link DecimalFormat} on every invocation with the format string "<code>0.000E0;
     * -</code>".
     *
     * @return the string representation
     */
    public String toString() {
        DecimalFormat formatter = new DecimalFormat(" 0.000E0;-");
        String str = toString(formatter);
        StringBuffer res = new StringBuffer();
        int eIndex = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'E') {
                eIndex = i;
            } else if (c == ' ' && eIndex == i - 1) {
                // workaround Java 1.4 DecimalFormat bug
                res.append('+');
                continue;
            } else if (Character.isDigit(c) && eIndex == i - 1) {
                res.append('+');
            }
            res.append(c);
        }
        return res.toString();
    }

    /**
     * Return a string representation of this matrix by formatting the matrix elements with the given
     * {@link NumberFormat}.
     *
     * @param formatter the {@link NumberFormat} used to format the matrix values with
     * @return the string representation
     */
    public String toString(NumberFormat formatter) {
        return formatter.format(val[0]) + " " + formatter.format(val[2]) + "\n"
                + formatter.format(val[1]) + " " + formatter.format(val[3]) + "\n";
    }

    /**
     * Get the current values of <code>this</code> matrix and store them into
     * <code>dest</code>.
     * <p>
     * This is the reverse method of {@link #set(Matrix2fx)} and allows to obtain
     * intermediate calculation results when chaining multiple transformations.
     *
     * @param dest the destination matrix
     * @return the passed in destination
     * @see #set(Matrix2fx)
     */
    public Matrix2fx get(Matrix2fx dest) {
        return dest.set(this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(org.joml.Matrix3x2f)
     */
    public Matrix3x2f get(Matrix3x2f dest) {
        NIE();
//        return dest.set(this);
        return null;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(org.joml.Matrix3f)
     */
    public Matrix3f get(Matrix3f dest) {
        NIE();
//        return dest.set(this);
        return null;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#getRotation()
     */
    public float getRotation() {
        return (float) org.joml.Math.atan2(val[1], val[3]);
    }

    //#ifdef __GWT__
    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(com.google.gwt.typedarrays.shared.Float32Array)
     */
    public Float32Array get(Float32Array buffer) {
        buffer.set(0, val[0]);
        buffer.set(1, val[1]);
        buffer.set(2, val[2]);
        buffer.set(3, val[3]);
        return buffer;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(int, com.google.gwt.typedarrays.shared.Float32Array)
     */
    public Float32Array get(int index, Float32Array buffer) {
        buffer.set(index, val[0]);
        buffer.set(index + 1, val[1]);
        buffer.set(index + 2, val[2]);
        buffer.set(index + 3, val[3]);
        return buffer;
    }
//#endif

    //#ifdef __HAS_NIO__
    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(java.nio.FloatBuffer)
     */
    public FloatBuffer get(FloatBuffer buffer) {
        return get(buffer.position(), buffer);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(int, java.nio.FloatBuffer)
     */
    public FloatBuffer get(int index, FloatBuffer buffer) {
        if (index == 0) {
            buffer.put(this.val, 0, 4);
        } else {
            buffer.put(index++, val[0]);
            buffer.put(index++, val[1]);
            buffer.put(index++, val[2]);
            buffer.put(index++, val[3]);
        }
        return buffer;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(java.nio.ByteBuffer)
     */
    public ByteBuffer get(ByteBuffer buffer) {
        return get(buffer.position(), buffer);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(int, java.nio.ByteBuffer)
     */
    public ByteBuffer get(int index, ByteBuffer buffer) {
        buffer.putFloat(index, val[0]);
        index += 4;
        buffer.putFloat(index, val[1]);
        index += 4;
        buffer.putFloat(index, val[2]);
        index += 4;
        buffer.putFloat(index, val[3]);
//        MemUtil.INSTANCE.put(this, index, buffer);
        return buffer;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#getTransposed(java.nio.FloatBuffer)
     */
    public FloatBuffer getTransposed(FloatBuffer buffer) {
        return get(buffer.position(), buffer);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#getTransposed(int, java.nio.FloatBuffer)
     */
    public FloatBuffer getTransposed(int index, FloatBuffer buffer) {
        buffer.put(index, val[0]);
        buffer.put(index + 1, val[2]);
        buffer.put(index + 2, val[1]);
        buffer.put(index + 3, val[3]);
        return buffer;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#getTransposed(java.nio.ByteBuffer)
     */
    public ByteBuffer getTransposed(ByteBuffer buffer) {
        return get(buffer.position(), buffer);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#getTransposed(int, java.nio.ByteBuffer)
     */
    public ByteBuffer getTransposed(int index, ByteBuffer buffer) {
        buffer.putFloat(index, val[0]);
        buffer.putFloat(index + 4, val[2]);
        buffer.putFloat(index + 8, val[1]);
        buffer.putFloat(index + 12, val[3]);
        return buffer;
    }

    //#endif
//#ifdef __HAS_UNSAFE__
    public Matrix2fx getToAddress(long address) {
        NIE();
//        if (Options.NO_UNSAFE)
//            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
//        MemUtil.MemUtilUnsafe unsafe = (MemUtil.MemUtilUnsafe) MemUtil.INSTANCE;
//        unsafe.put(this, address);
//        return this;
        return null;
    }
//#endif

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(float[], int)
     */
    public float[] get(float[] arr, int offset) {
        System.arraycopy(this.val, 0, arr, offset, 4);
        return arr;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(float[])
     */
    public float[] get(float[] arr) {
        return get(arr, 0);
    }

//#ifdef __HAS_NIO__

    /**
     * Set the values of this matrix by reading 4 float values from the given {@link FloatBuffer} in column-major order,
     * starting at its current position.
     * <p>
     * The FloatBuffer is expected to contain the values in column-major order.
     * <p>
     * The position of the FloatBuffer will not be changed by this method.
     *
     * @param buffer the FloatBuffer to read the matrix values from in column-major order
     * @return this
     */
    public Matrix2fx set(FloatBuffer buffer) {
//        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        int index = buffer.position();
        this.val[0] = buffer.get(index++);
        this.val[1] = buffer.get(index++);
        this.val[2] = buffer.get(index++);
        this.val[3] = buffer.get(index);
        return this;
    }

    /**
     * Set the values of this matrix by reading 4 float values from the given {@link ByteBuffer} in column-major order,
     * starting at its current position.
     * <p>
     * The ByteBuffer is expected to contain the values in column-major order.
     * <p>
     * The position of the ByteBuffer will not be changed by this method.
     *
     * @param buffer the ByteBuffer to read the matrix values from in column-major order
     * @return this
     */
    public Matrix2fx set(ByteBuffer buffer) {
//        MemUtil.INSTANCE.get(this, buffer.position(), buffer);
        int index = buffer.position();
        this.val[0] = buffer.getFloat(index);
        index += 4;
        this.val[1] = buffer.getFloat(index);
        index += 4;
        this.val[2] = buffer.getFloat(index);
        index += 4;
        this.val[3] = buffer.getFloat(index);
        return this;
    }
//#endif

//#ifdef __HAS_UNSAFE__

    /**
     * Set the values of this matrix by reading 4 float values from off-heap memory in column-major order,
     * starting at the given address.
     * <p>
     * This method will throw an {@link UnsupportedOperationException} when JOML is used with `-Djoml.nounsafe`.
     * <p>
     * <em>This method is unsafe as it can result in a crash of the JVM process when the specified address range does
     * not belong to this process.</em>
     *
     * @param address the off-heap memory address to read the matrix values from in column-major order
     * @return this
     */
    public Matrix2fx setFromAddress(long address) {
        NIE();
//        if (Options.NO_UNSAFE)
//            throw new UnsupportedOperationException("Not supported when using joml.nounsafe");
//        MemUtil.MemUtilUnsafe unsafe = (MemUtil.MemUtilUnsafe) MemUtil.INSTANCE;
//        unsafe.get(this, address);
//        return this;
        return null;
    }
//#endif

    /**
     * Set all values within this matrix to zero.
     *
     * @return this
     */
    public Matrix2fx zero() {
        Arrays.fill(this.val, 0);
        return this;
    }

    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    public Matrix2fx identity() {
        val[0] = 1.0f;
        val[1] = 0.0f;
        val[2] = 0.0f;
        val[3] = 1.0f;
        return this;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#scale(org.joml.Vector2fc, org.joml.test.Matrix2fx)
     */
    public Matrix2fx scale(Vector2fc xy, Matrix2fx dest) {
        return scale(xy.x(), xy.y(), dest);
    }

    /**
     * Apply scaling to this matrix by scaling the base axes by the given <code>xy.x</code> and
     * <code>xy.y</code> factors, respectively.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the scaling matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>, the
     * scaling will be applied first!
     *
     * @param xy the factors of the x and y component, respectively
     * @return this
     */
    public Matrix2fx scale(Vector2fc xy) {
        return scale(xy.x(), xy.y(), this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#scale(float, float, org.joml.test.Matrix2fx)
     */
    public Matrix2fx scale(float x, float y, Matrix2fx dest) {
        // scale matrix elements:
        // m00 = x, m11 = y
        // all others = 0
        dest.val[0] = val[0] * x;
        dest.val[1] = val[1] * x;
        dest.val[2] = val[2] * y;
        dest.val[3] = val[3] * y;
        return dest;
    }

    /**
     * Apply scaling to this matrix by scaling the base axes by the given x and
     * y factors.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the scaling matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>
     * , the scaling will be applied first!
     *
     * @param x the factor of the x component
     * @param y the factor of the y component
     * @return this
     */
    public Matrix2fx scale(float x, float y) {
        return scale(x, y, this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#scale(float, org.joml.test.Matrix2fx)
     */
    public Matrix2fx scale(float xy, Matrix2fx dest) {
        return scale(xy, xy, dest);
    }

    /**
     * Apply scaling to this matrix by uniformly scaling all base axes by the given <code>xy</code> factor.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the scaling matrix,
     * then the new matrix will be <code>M * S</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * S * v</code>
     * , the scaling will be applied first!
     *
     * @param xy the factor for all components
     * @return this
     * @see #scale(float, float)
     */
    public Matrix2fx scale(float xy) {
        return scale(xy, xy);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#scaleLocal(float, float, org.joml.test.Matrix2fx)
     */
    public Matrix2fx scaleLocal(float x, float y, Matrix2fx dest) {
        dest.val[0] = x * val[0];
        dest.val[1] = y * val[1];
        dest.val[2] = x * val[2];
        dest.val[3] = y * val[3];
        return dest;
    }

    /**
     * Pre-multiply scaling to this matrix by scaling the base axes by the given x and
     * y factors.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>S</code> the scaling matrix,
     * then the new matrix will be <code>S * M</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>S * M * v</code>, the
     * scaling will be applied last!
     *
     * @param x the factor of the x component
     * @param y the factor of the y component
     * @return this
     */
    public Matrix2fx scaleLocal(float x, float y) {
        return scaleLocal(x, y, this);
    }

    /**
     * Set this matrix to be a simple scale matrix, which scales all axes uniformly by the given factor.
     * <p>
     * The resulting matrix can be multiplied against another transformation
     * matrix to obtain an additional scaling.
     * <p>
     * In order to post-multiply a scaling transformation directly to a
     * matrix, use {@link #scale(float) scale()} instead.
     *
     * @param factor the scale factor in x and y
     * @return this
     * @see #scale(float)
     */
    public Matrix2fx scaling(float factor) {
        Arrays.fill(val, 0);
        val[0] = factor;
        val[3] = factor;
        return this;
    }

    /**
     * Set this matrix to be a simple scale matrix.
     *
     * @param x the scale in x
     * @param y the scale in y
     * @return this
     */
    public Matrix2fx scaling(float x, float y) {
        Arrays.fill(val, 0);
        val[0] = x;
        val[3] = y;
        return this;
    }

    /**
     * Set this matrix to be a simple scale matrix which scales the base axes by <code>xy.x</code> and <code>xy
     * .y</code> respectively.
     * <p>
     * The resulting matrix can be multiplied against another transformation
     * matrix to obtain an additional scaling.
     * <p>
     * In order to post-multiply a scaling transformation directly to a
     * matrix use {@link #scale(Vector2fc) scale()} instead.
     *
     * @param xy the scale in x and y respectively
     * @return this
     * @see #scale(Vector2fc)
     */
    public Matrix2fx scaling(Vector2fc xy) {
        return scaling(xy.x(), xy.y());
    }

    /**
     * Set this matrix to a rotation matrix which rotates the given radians about the origin.
     * <p>
     * The produced rotation will rotate a vector counter-clockwise around the origin.
     * <p>
     * The resulting matrix can be multiplied against another transformation
     * matrix to obtain an additional rotation.
     * <p>
     * In order to post-multiply a rotation transformation directly to a
     * matrix, use {@link #rotate(float) rotate()} instead.
     *
     * @param angle the angle in radians
     * @return this
     * @see #rotate(float)
     */
    public Matrix2fx rotation(float angle) {
        float sin = (float) org.joml.Math.sin(angle);
        float cos = (float) org.joml.Math.cosFromSin(sin, angle);
        val[0] = cos;
        val[1] = sin;
        val[2] = -sin;
        val[3] = cos;
        return this;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#transform(org.joml.Vector2f)
     */
    public Vector2f transform(Vector2f v) {
        NIE();
//        return v.mul(this);
        return null;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#transform(org.joml.Vector2fc, org.joml.Vector2f)
     */
    public Vector2f transform(Vector2fc v, Vector2f dest) {
        NIE();
//        v.mul(this, dest);
//        return dest;
        return null;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#transform(float, float, org.joml.Vector2f)
     */
    public Vector2f transform(float x, float y, Vector2f dest) {
        dest.set(val[0] * x + val[2] * y,
                val[1] * x + val[3] * y);
        return dest;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#transformTranspose(org.joml.Vector2f)
     */
    public Vector2f transformTranspose(Vector2f v) {
        NIE();
//        return v.mulTranspose(this);
        return null;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#transformTranspose(org.joml.Vector2fc, org.joml.Vector2f)
     */
    public Vector2f transformTranspose(Vector2fc v, Vector2f dest) {
//        v.mulTranspose(this, dest);
//        return dest;
        return null;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#transformTranspose(float, float, org.joml.Vector2f)
     */
    public Vector2f transformTranspose(float x, float y, Vector2f dest) {
        dest.set(val[0] * x + val[1] * y,
                val[2] * x + val[3] * y);
        return dest;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(val[0]);
        out.writeFloat(val[1]);
        out.writeFloat(val[2]);
        out.writeFloat(val[3]);
    }

    public void readExternal(ObjectInput in) throws IOException {
        val[0] = in.readFloat();
        val[1] = in.readFloat();
        val[2] = in.readFloat();
        val[3] = in.readFloat();
    }

    /**
     * Apply rotation about the origin to this matrix by rotating the given amount of radians.
     * <p>
     * The produced rotation will rotate a vector counter-clockwise around the origin.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>
     * , the rotation will be applied first!
     * <p>
     * Reference: <a href="https://en.wikipedia.org/wiki/Rotation_matrix#In_two_dimensions">http://en.wikipedia.org</a>
     *
     * @param angle the angle in radians
     * @return this
     */
    public Matrix2fx rotate(float angle) {
        return rotate(angle, this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#rotate(float, org.joml.test.Matrix2fx)
     */
    public Matrix2fx rotate(float angle, Matrix2fx dest) {
        float s = (float) org.joml.Math.sin(angle);
        float c = (float) org.joml.Math.cosFromSin(s, angle);
        // rotation matrix elements:
        // m00 = c, m01 = s, m10 = -s, m11 = c
        float nm00 = val[0] * c + val[2] * s;
        float nm01 = val[1] * c + val[3] * s;
        float nm10 = val[2] * c - val[0] * s;
        float nm11 = val[3] * c - val[1] * s;
        dest.val[0] = nm00;
        dest.val[1] = nm01;
        dest.val[2] = nm10;
        dest.val[3] = nm11;
        return dest;
    }

    /**
     * Pre-multiply a rotation to this matrix by rotating the given amount of radians about the origin.
     * <p>
     * The produced rotation will rotate a vector counter-clockwise around the origin.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the rotation matrix,
     * then the new matrix will be <code>R * M</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>R * M * v</code>, the
     * rotation will be applied last!
     * <p>
     * In order to set the matrix to a rotation matrix without pre-multiplying the rotation
     * transformation, use {@link #rotation(float) rotation()}.
     * <p>
     * Reference: <a href="https://en.wikipedia.org/wiki/Rotation_matrix#In_two_dimensions">http://en.wikipedia.org</a>
     *
     * @param angle the angle in radians to rotate about the X axis
     * @return this
     * @see #rotation(float)
     */
    public Matrix2fx rotateLocal(float angle) {
        return rotateLocal(angle, this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#rotateLocal(float, org.joml.test.Matrix2fx)
     */
    public Matrix2fx rotateLocal(float angle, Matrix2fx dest) {
        float s = (float) org.joml.Math.sin(angle);
        float c = (float) org.joml.Math.cosFromSin(s, angle);
        // rotation matrix elements:
        // m00 = c, m01 = s, m10 = -s, m11 = c
        float nm00 = c * val[0] - s * val[1];
        float nm01 = s * val[0] + c * val[1];
        float nm10 = c * val[2] - s * val[3];
        float nm11 = s * val[2] + c * val[3];
        dest.val[0] = nm00;
        dest.val[1] = nm01;
        dest.val[2] = nm10;
        dest.val[3] = nm11;
        return dest;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#getRow(int, org.joml.Vector2f)
     */
    public Vector2f getRow(int row, Vector2f dest) throws IndexOutOfBoundsException {
        switch (row) {
            case 0:
                dest.x = val[0];
                dest.y = val[2];
                break;
            case 1:
                dest.x = val[1];
                dest.y = val[3];
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
        return dest;
    }

    /**
     * Set the row at the given <code>row</code> index, starting with <code>0</code>.
     *
     * @param row the row index in <code>[0..1]</code>
     * @param src the row components to set
     * @return this
     * @throws IndexOutOfBoundsException if <code>row</code> is not in <code>[0..1]</code>
     */
    public Matrix2fx setRow(int row, Vector2fc src) throws IndexOutOfBoundsException {
        return setRow(row, src.x(), src.y());
    }

    /**
     * Set the row at the given <code>row</code> index, starting with <code>0</code>.
     *
     * @param row the row index in <code>[0..1]</code>
     * @param x   the first element in the row
     * @param y   the second element in the row
     * @return this
     * @throws IndexOutOfBoundsException if <code>row</code> is not in <code>[0..1]</code>
     */
    public Matrix2fx setRow(int row, float x, float y) throws IndexOutOfBoundsException {
        switch (row) {
            case 0:
                this.val[0] = x;
                this.val[2] = y;
                break;
            case 1:
                this.val[1] = x;
                this.val[3] = y;
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
        return this;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#getColumn(int, org.joml.Vector2f)
     */
    public Vector2f getColumn(int column, Vector2f dest) throws IndexOutOfBoundsException {
        switch (column) {
            case 0:
                dest.x = val[0];
                dest.y = val[1];
                break;
            case 1:
                dest.x = val[2];
                dest.y = val[3];
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
        return dest;
    }

    /**
     * Set the column at the given <code>column</code> index, starting with <code>0</code>.
     *
     * @param column the column index in <code>[0..1]</code>
     * @param src    the column components to set
     * @return this
     * @throws IndexOutOfBoundsException if <code>column</code> is not in <code>[0..1]</code>
     */
    public Matrix2fx setColumn(int column, Vector2fc src) throws IndexOutOfBoundsException {
        return setColumn(column, src.x(), src.y());
    }

    /**
     * Set the column at the given <code>column</code> index, starting with <code>0</code>.
     *
     * @param column the column index in <code>[0..1]</code>
     * @param x      the first element in the column
     * @param y      the second element in the column
     * @return this
     * @throws IndexOutOfBoundsException if <code>column</code> is not in <code>[0..1]</code>
     */
    public Matrix2fx setColumn(int column, float x, float y) throws IndexOutOfBoundsException {
        switch (column) {
            case 0:
                this.val[0] = x;
                this.val[1] = y;
                break;
            case 1:
                this.val[2] = x;
                this.val[3] = y;
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
        return this;
    }

    /*
     * (non-Javadoc)
     * @see org.joml.test.Matrix2fx#get(int, int)
     */
    public float get(int column, int row) {
        switch (column) {
            case 0:
                switch (row) {
                    case 0:
                        return val[0];
                    case 1:
                        return val[1];
                    default:
                        break;
                }
                break;
            case 1:
                switch (row) {
                    case 0:
                        return val[2];
                    case 1:
                        return val[3];
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Set the matrix element at the given column and row to the specified value.
     *
     * @param column the colum index in <code>[0..1]</code>
     * @param row    the row index in <code>[0..1]</code>
     * @param value  the value
     * @return this
     */
    public Matrix2fx set(int column, int row, float value) {
        val[column * 2 + row] = value;
        return this;
    }

    /**
     * Set <code>this</code> matrix to its own normal matrix.
     * <p>
     * Please note that, if <code>this</code> is an orthogonal matrix or a matrix whose columns are orthogonal vectors,
     * then this method <i>need not</i> be invoked, since in that case <code>this</code> itself is its normal matrix.
     * In this case, use {@link #set(Matrix2fx)} to set a given Matrix2fx to this matrix.
     *
     * @return this
     * @see #set(Matrix2fx)
     */
    public Matrix2fx normal() {
        return normal(this);
    }

    /**
     * Compute a normal matrix from <code>this</code> matrix and store it into <code>dest</code>.
     * <p>
     * Please note that, if <code>this</code> is an orthogonal matrix or a matrix whose columns are orthogonal vectors,
     * then this method <i>need not</i> be invoked, since in that case <code>this</code> itself is its normal matrix.
     * In this case, use {@link #set(Matrix2fx)} to set a given Matrix2fx to this matrix.
     *
     * @param dest will hold the result
     * @return dest
     * @see #set(Matrix2fx)
     */
    public Matrix2fx normal(Matrix2fx dest) {
        float det = val[0] * val[3] - val[2] * val[1];
        float s = 1.0f / det;
        /* Invert and transpose in one go */
        float nm00 = val[3] * s;
        float nm01 = -val[2] * s;
        float nm10 = -val[1] * s;
        float nm11 = val[0] * s;
        dest.val[0] = nm00;
        dest.val[1] = nm01;
        dest.val[2] = nm10;
        dest.val[3] = nm11;
        return dest;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#getScale(org.joml.Vector2f)
     */
    public Vector2f getScale(Vector2f dest) {
        dest.x = (float) org.joml.Math.sqrt(val[0] * val[0] + val[1] * val[1]);
        dest.y = (float) Math.sqrt(val[2] * val[2] + val[3] * val[3]);
        return dest;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#positiveX(org.joml.Vector2f)
     */
    public Vector2f positiveX(Vector2f dir) {
        if (val[0] * val[3] < val[1] * val[2]) { // negative determinant?
            dir.x = -val[3];
            dir.y = val[1];
        } else {
            dir.x = val[3];
            dir.y = -val[1];
        }
        return dir.normalize(dir);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#normalizedPositiveX(org.joml.Vector2f)
     */
    public Vector2f normalizedPositiveX(Vector2f dir) {
        if (val[0] * val[3] < val[1] * val[2]) { // negative determinant?
            dir.x = -val[3];
            dir.y = val[1];
        } else {
            dir.x = val[3];
            dir.y = -val[1];
        }
        return dir;
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#positiveY(org.joml.Vector2f)
     */
    public Vector2f positiveY(Vector2f dir) {
        if (val[0] * val[3] < val[1] * val[2]) { // negative determinant?
            dir.x = val[2];
            dir.y = -val[0];
        } else {
            dir.x = -val[2];
            dir.y = val[0];
        }
        return dir.normalize(dir);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#normalizedPositiveY(org.joml.Vector2f)
     */
    public Vector2f normalizedPositiveY(Vector2f dir) {
        if (val[0] * val[3] < val[1] * val[2]) { // negative determinant?
            dir.x = val[2];
            dir.y = -val[0];
        } else {
            dir.x = -val[2];
            dir.y = val[0];
        }
        return dir;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(val[0]);
        result = prime * result + Float.floatToIntBits(val[1]);
        result = prime * result + Float.floatToIntBits(val[2]);
        result = prime * result + Float.floatToIntBits(val[3]);
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matrix2fx other = (Matrix2fx) obj;
        if (Float.floatToIntBits(val[0]) != Float.floatToIntBits(other.val[0]))
            return false;
        if (Float.floatToIntBits(val[1]) != Float.floatToIntBits(other.val[1]))
            return false;
        if (Float.floatToIntBits(val[2]) != Float.floatToIntBits(other.val[2]))
            return false;
        if (Float.floatToIntBits(val[3]) != Float.floatToIntBits(other.val[3]))
            return false;
        return true;
    }

    public boolean equals(Matrix2fx m, float delta) {
        if (this == m)
            return true;
        if (m == null)
            return false;
        if (!(m instanceof Matrix2fx))
            return false;
        if (!Runtime.equals(val[0], m.m00(), delta))
            return false;
        if (!Runtime.equals(val[1], m.m01(), delta))
            return false;
        if (!Runtime.equals(val[2], m.m10(), delta))
            return false;
        if (!Runtime.equals(val[3], m.m11(), delta))
            return false;
        return true;
    }

    /**
     * Exchange the values of <code>this</code> matrix with the given <code>other</code> matrix.
     *
     * @param other the other matrix to exchange the values with
     * @return this
     */
    public Matrix2fx swap(Matrix2fx other) {
        float[] temp = this.val;
        this.val = other.val;
        other.val = temp;
        return this;
    }

    /**
     * Component-wise add <code>this</code> and <code>other</code>.
     *
     * @param other the other addend
     * @return this
     */
    public Matrix2fx add(Matrix2fx other) {
        return add(other, this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#add(org.joml.test.Matrix2fx, org.joml.test.Matrix2fx)
     */
    public Matrix2fx add(Matrix2fx other, Matrix2fx dest) {
        dest.val[0] = val[0] + other.m00();
        dest.val[1] = val[1] + other.m01();
        dest.val[2] = val[2] + other.m10();
        dest.val[3] = val[3] + other.m11();
        return dest;
    }

    /**
     * Component-wise subtract <code>subtrahend</code> from <code>this</code>.
     *
     * @param subtrahend the subtrahend
     * @return this
     */
    public Matrix2fx sub(Matrix2fx subtrahend) {
        return sub(subtrahend, this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#sub(org.joml.test.Matrix2fx, org.joml.test.Matrix2fx)
     */
    public Matrix2fx sub(Matrix2fx other, Matrix2fx dest) {
        dest.val[0] = val[0] - other.m00();
        dest.val[1] = val[1] - other.m01();
        dest.val[2] = val[2] - other.m10();
        dest.val[3] = val[3] - other.m11();
        return dest;
    }

    /**
     * Component-wise multiply <code>this</code> by <code>other</code>.
     *
     * @param other the other matrix
     * @return this
     */
    public Matrix2fx mulComponentWise(Matrix2fx other) {
        return sub(other, this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#mulComponentWise(org.joml.test.Matrix2fx, org.joml.test.Matrix2fx)
     */
    public Matrix2fx mulComponentWise(Matrix2fx other, Matrix2fx dest) {
        dest.val[0] = val[0] * other.m00();
        dest.val[1] = val[1] * other.m01();
        dest.val[2] = val[2] * other.m10();
        dest.val[3] = val[3] * other.m11();
        return dest;
    }

    /**
     * Linearly interpolate <code>this</code> and <code>other</code> using the given interpolation factor <code>t</code>
     * and store the result in <code>this</code>.
     * <p>
     * If <code>t</code> is <code>0.0</code> then the result is <code>this</code>. If the interpolation factor is
     * <code>1.0</code>
     * then the result is <code>other</code>.
     *
     * @param other the other matrix
     * @param t     the interpolation factor between 0.0 and 1.0
     * @return this
     */
    public Matrix2fx lerp(Matrix2fx other, float t) {
        return lerp(other, t, this);
    }

    /* (non-Javadoc)
     * @see org.joml.test.Matrix2fx#lerp(org.joml.test.Matrix2fx, float, org.joml.test.Matrix2fx)
     */
    public Matrix2fx lerp(Matrix2fx other, float t, Matrix2fx dest) {
        dest.val[0] = val[0] + (other.m00() - val[0]) * t;
        dest.val[1] = val[1] + (other.m01() - val[1]) * t;
        dest.val[2] = val[2] + (other.m10() - val[2]) * t;
        dest.val[3] = val[3] + (other.m11() - val[3]) * t;
        return dest;
    }

}


public class Matrix2fPerformanceTest extends TestCase {

    public static void test() {
        Matrix2f a = new Matrix2f(1, 2, 3, 4);
        Matrix2fx b = new Matrix2fx(1, 2, 3, 4);
        final int loop = 100000000;
        long start, end;

        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            a.invert();
            a = a.add(new Matrix2f(a));
            a.invert();
            a = a.mul(new Matrix2f(a));
            a.invert();
            a.normal();
            a.scale(5);
            a.identity();
        }
        end = System.currentTimeMillis();
        long timea = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            b.invert();
            b = b.add(new Matrix2fx(b));
            b.invert();
            b = b.mul(new Matrix2fx(b));
            b.invert();
            b.normal();
            b.scale(5);
            b.identity();
        }
        end = System.currentTimeMillis();
        long timeb = end - start;
        System.out.println("timea:" + timea);
        System.out.println("timeb:" + timeb);
        assertTrue(Float.compare(a.m00(), b.m00()) == 0);
        assertTrue(Float.compare(a.m01(), b.m01()) == 0);
        assertTrue(Float.compare(a.m10(), b.m10()) == 0);
        assertTrue(Float.compare(a.m11(), b.m11()) == 0);
        assertTrue(timea < timeb);
        b.invert();
    }

}
