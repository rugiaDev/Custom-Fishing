/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customfishing.fishing.requirements;

import net.momirealms.customfishing.fishing.FishingCondition;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class YPosImpl extends Requirement implements RequirementInterface {

    private final List<String> yPos;

    public YPosImpl(@Nullable String[] msg, List<String> yPos) {
        super(msg);
        this.yPos = yPos;
    }

    @Override
    public boolean isConditionMet(FishingCondition fishingCondition) {
        int y = (int) fishingCondition.getLocation().getY();
        for (String range : yPos) {
            String[] yMinMax = StringUtils.split(range, "~");
            if (y > Integer.parseInt(yMinMax[0]) && y < Integer.parseInt(yMinMax[1])) {
                return true;
            }
        }
        notMetMessage(fishingCondition.getPlayer());
        return false;
    }
}