package igentuman.nc.block.entity.processor;

import igentuman.nc.setup.registration.NCProcessors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ChemicalReactorBE extends NCProcessor {
    public static String NAME = "chemical_reactor";
    public ChemicalReactorBE(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState, NAME);
    }
    @Override
    public String getName() {
        return NAME;
    }
}