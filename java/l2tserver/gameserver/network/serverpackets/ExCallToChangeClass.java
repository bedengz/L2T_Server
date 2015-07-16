/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l2tserver.gameserver.network.serverpackets;

import l2tserver.gameserver.datatables.PlayerClassTable;

/**
 * @author Pere
 */
public final class ExCallToChangeClass extends L2GameServerPacket
{
	private int _awakeningId;
	private boolean _show;
	
	public ExCallToChangeClass(int classId, boolean show)
	{
		_awakeningId = PlayerClassTable.getInstance().getAwakening(classId);
		_show = show;
	}
	
	@Override
	protected void writeImpl()
	{
		writeC(0xfe);
		writeH(0xfe);
		writeD(_awakeningId);
		writeD(_show ? 1 : 0);
		writeD(0x01);
	}
	
	/* (non-Javadoc)
	 * @see l2tserver.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	@Override
	public String getType()
	{
		return "ExCallToChangeClass";
	}
}