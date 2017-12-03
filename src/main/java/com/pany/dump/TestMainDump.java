package com.pany.dump;

import org.objectweb.asm.*;

public class TestMainDump implements Opcodes {
	void foo() {
		try {
			System.out.println(new String("testtest"));

		} catch (Exception e) {
			e.printStackTrace();

		}
		return;
	}

	/*
	 * Try ~ cache dump
	 */
	public byte[] fooDump() throws Exception {
		/*
		 * void foo(){ try{ System.out.println(new String("testtest"));
		 * 
		 * } catch(Exception e){ e.printStackTrace();
		 * 
		 * } return; }
		 */

		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;
		AnnotationVisitor av0;

		cw.visit(V1_5, ACC_PUBLIC + ACC_SUPER, "com/pany/src/TestMain", null, "java/lang/Object", null);

		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		mv = cw.visitMethod(0, "foo", "()V", null, null);
		mv.visitCode();
		Label l0 = new Label();
		Label l1 = new Label();
		Label l2 = new Label();
		mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
		mv.visitLabel(l0);
		mv.visitLineNumber(10, l0);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitTypeInsn(NEW, "java/lang/String");
		mv.visitInsn(DUP);
		mv.visitLdcInsn("testtest");
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/String", "<init>", "(Ljava/lang/String;)V", false);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		mv.visitLabel(l1);
		mv.visitLineNumber(12, l1);
		Label l3 = new Label();
		mv.visitJumpInsn(GOTO, l3);
		mv.visitLabel(l2);
		mv.visitLineNumber(13, l2);
		mv.visitVarInsn(ASTORE, 1);
		Label l4 = new Label();
		mv.visitLabel(l4);
		mv.visitLineNumber(14, l4);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Exception", "printStackTrace", "()V", false);
		mv.visitLabel(l3);
		mv.visitLineNumber(17, l3);
		mv.visitInsn(RETURN);
		Label l5 = new Label();
		mv.visitLabel(l5);
		mv.visitLocalVariable("this", "Lcom/pany/src/TestMain;", null, l0, l5, 0);
		mv.visitLocalVariable("e", "Ljava/lang/Exception;", null, l4, l3, 1);
		mv.visitMaxs(4, 2);
		mv.visitEnd();

		cw.visitEnd();

		return cw.toByteArray();
	}

	/*
	 * add Int + Int
	 */
	int fooAddII() {
		return 1 + 2;
	}

	/*
	 * add Parameter int + Int
	 */
	int fooAddPI(int i) {
		return i + 2;
	}
}
