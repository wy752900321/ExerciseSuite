/*
 * Copyright (c) 2007 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the GNU Lesser General Public License, Version 2.1. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.gnu.org/licenses/lgpl-2.1.txt. The Original Code is Pentaho 
 * Data Integration.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the GNU Lesser Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
*/
package com.cenrise.source.vfs;

import java.io.IOException;
import java.lang.reflect.Method;

import com.cenrise.source.variables.VariableSpace;
import org.apache.commons.vfs.FileSystemConfigBuilder;

import com.cenrise.source.variables.VariableSpace;


/**
 * This class supports overriding of config builders by supplying a VariableSpace containing a variable in the format of
 * vfs.[scheme].config.parser where [scheme] is one of the VFS schemes (file, http, sftp, etc...)
 * 
 * @author cboyden
 */
public class KettleFileSystemConfigBuilderFactory {
  
  private static Class<?> PKG = KettleVFS.class; // for i18n purposes, needed by Translator2!!   $NON-NLS-1$

  /**
   * This factory returns a FileSystemConfigBuilder.
   * Custom FileSystemConfigBuilders can be created by implementing the {@link IKettleFileSystemConfigBuilder}
   * or overriding the {@link KettleGenericFileSystemConfigBuilder}
   * 
   * @see FileSystemConfigBuilder
   * 
   * @param varSpace A Kettle variable space for resolving VFS config parameters
   * @param scheme The VFS scheme (FILE, HTTP, SFTP, etc...)
   * @return A FileSystemConfigBuilder that can translate Kettle variables into VFS config parameters
   * @throws IOException
   */
  public static IKettleFileSystemConfigBuilder getConfigBuilder(VariableSpace varSpace, String scheme) throws IOException {
    IKettleFileSystemConfigBuilder result = null;
    
    // Attempt to load the Config Builder from a variable: vfs.config.parser = class
    String parserClass = varSpace.getVariable("vfs." + scheme + ".config.parser"); //$NON-NLS-1$ //$NON-NLS-2$
    
    if(parserClass != null) {
      try {
        Class<?> configBuilderClass = KettleFileSystemConfigBuilderFactory.class.getClassLoader().loadClass(parserClass);
        Method mGetInstance = configBuilderClass.getMethod("getInstance"); //$NON-NLS-1$
        if((mGetInstance != null) && (IKettleFileSystemConfigBuilder.class.isAssignableFrom(mGetInstance.getReturnType()))) {
          result = (IKettleFileSystemConfigBuilder)mGetInstance.invoke(null);
        } else {
          result = (IKettleFileSystemConfigBuilder)configBuilderClass.newInstance();
        }
      } catch (Exception e) {
        // Failed to load custom parser. Throw exception.
        throw new IOException("加载自定义vfs设置解析器失败"); //$NON-NLS-1$
      }
    } else {
      // No custom parser requested, load default
      if(scheme.equalsIgnoreCase("sftp")) { //$NON-NLS-1$
        result = KettleSftpFileSystemConfigBuilder.getInstance();
      } else {
        result = KettleGenericFileSystemConfigBuilder.getInstance();
      }
    }
    
    return result;
  }

}
