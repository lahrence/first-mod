/*
 * Minecraft Forge
 * Copyright (c) 2016-2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.client.event.sound;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;

/***
 * Raised when the SoundManager tries to play a normal sound.
 *
 * If you return null from this function it will prevent the sound from being played,
 * you can return a different entry if you want to change the sound being played.
 */
public class PlaySoundEvent extends SoundEvent
{
    private final String name;
    private final SoundInstance originalSound;
    private SoundInstance sound;

    public PlaySoundEvent(SoundEngine manager, SoundInstance sound)
    {
        super(manager);
        this.originalSound = sound;
        this.name = sound.getLocation().getPath();
        this.setSound(sound);
    }

    public String getName()
    {
        return name;
    }

    public SoundInstance getOriginalSound()
    {
        return originalSound;
    }

    public SoundInstance getSound()
    {
        return sound;
    }

    public void setSound(SoundInstance result)
    {
        this.sound = result;
    }
}
