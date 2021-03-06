/*
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.furnace.container.simple.events;

import java.lang.annotation.Annotation;
import java.util.ServiceLoader;

import org.jboss.forge.furnace.addons.Addon;
import org.jboss.forge.furnace.container.simple.EventListener;
import org.jboss.forge.furnace.event.EventException;
import org.jboss.forge.furnace.event.EventManager;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public class SimpleEventManagerImpl implements EventManager
{
   public SimpleEventManagerImpl(Addon addon)
   {
   }

   @Override
   public void fireEvent(Object event, Annotation... qualifiers) throws EventException
   {
      Iterable<EventListener> listeners = ServiceLoader.load(EventListener.class);
      for (EventListener listener : listeners)
      {
         listener.handleEvent(event, qualifiers);
      }
   }

}
