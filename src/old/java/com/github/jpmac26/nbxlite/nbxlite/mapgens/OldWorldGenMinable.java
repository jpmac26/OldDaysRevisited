package com.github.jpmac26.nbxlite.nbxlite.mapgens;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MathHelper;
import com.github.jpmac26.nbxlite.World;
import net.minecraft.src.WorldGenerator;

public class OldWorldGenMinable extends WorldGenerator
{
    private boolean bug;
    private int minableBlockId;
    private int numberOfBlocks;

    public OldWorldGenMinable(int i, int j, boolean b)
    {
        minableBlockId = i;
        numberOfBlocks = j;
        bug = b;
    }

    @Override
    public boolean generate(World world, Random random, int i, int j, int k)
    {
        float f = random.nextFloat() * 3.141593F;
        double d = (float)(i + 8) + (MathHelper.sin(f) * (float)numberOfBlocks) / 8F;
        double d1 = (float)(i + 8) - (MathHelper.sin(f) * (float)numberOfBlocks) / 8F;
        double d2 = (float)(k + 8) + (MathHelper.cos(f) * (float)numberOfBlocks) / 8F;
        double d3 = (float)(k + 8) - (MathHelper.cos(f) * (float)numberOfBlocks) / 8F;
        double d4 = j + random.nextInt(3) + 2;
        double d5 = j + random.nextInt(3) + 2;
        for(int l = 0; l <= numberOfBlocks; l++)
        {
            double d6 = d + ((d1 - d) * (double)l) / (double)numberOfBlocks;
            double d7 = d4 + ((d5 - d4) * (double)l) / (double)numberOfBlocks;
            double d8 = d2 + ((d3 - d2) * (double)l) / (double)numberOfBlocks;
            double d9 = (random.nextDouble() * (double)numberOfBlocks) / 16D;
            double d10 = (double)(MathHelper.sin(((float)l * 3.141593F) / (float)numberOfBlocks) + 1.0F) * d9 + 1.0D;
            double d11 = (double)(MathHelper.sin(((float)l * 3.141593F) / (float)numberOfBlocks) + 1.0F) * d9 + 1.0D;
            int i1 = bug ? (int)(d6 - d10 / 2D) : MathHelper.floor_double(d6 - d10 / 2D);
            int j1 = bug ? (int)(d7 - d11 / 2D) : MathHelper.floor_double(d7 - d11 / 2D);
            int k1 = bug ? (int)(d8 - d10 / 2D) : MathHelper.floor_double(d8 - d10 / 2D);
            int l1 = bug ? (int)(d6 + d10 / 2D) : MathHelper.floor_double(d6 + d10 / 2D);
            int i2 = bug ? (int)(d7 + d11 / 2D) : MathHelper.floor_double(d7 + d11 / 2D);
            int j2 = bug ? (int)(d8 + d10 / 2D) : MathHelper.floor_double(d8 + d10 / 2D);
            for(int k2 = i1; k2 <= l1; k2++)
            {
                double d12 = (((double)k2 + 0.5D) - d6) / (d10 / 2D);
                if(d12 * d12 >= 1.0D)
                {
                    continue;
                }
                for(int l2 = j1; l2 <= i2; l2++)
                {
                    double d13 = (((double)l2 + 0.5D) - d7) / (d11 / 2D);
                    if(d12 * d12 + d13 * d13 >= 1.0D)
                    {
                        continue;
                    }
                    for(int i3 = k1; i3 <= j2; i3++)
                    {
                        double d14 = (((double)i3 + 0.5D) - d8) / (d10 / 2D);
                        if(d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && world.getBlockId(k2, l2, i3) == Block.stone.blockID)
                        {
                            world.setBlock(k2, l2, i3, minableBlockId);
                        }
                    }

                }

            }

        }

        return true;
    }
}
