package com.pany.src;

import org.objectweb.asm.*;

public class MyClassAdaptor extends ClassVisitor{
    /**
     * Constructs a new {@link org.objectweb.asm.ClassAdapter} object.
     *
     * @param cv the class visitor to which this adapter must delegate calls.
     */
    public MyClassAdaptor(ClassVisitor cv) {
    	super(Opcodes.ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        return new MyMethodAdapter(Opcodes.ASM5, mv, access, name, desc);
    }

}
