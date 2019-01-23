package com.tz.cms.sysmgr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of pm_sys_menu.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class PmSysMenu implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** menu_id. */
	private Integer menuId;

	/** menu_name. */
	private String menuName;

	/** parent_id. */
	private Integer parentId;

	/** sort. */
	private Integer sort;

	/** href. */
	private String href;

	/** target. */
	private String target;

	/** icon. */
	private String icon;

	/** permission. */
	private String permission;

	/** is_show. */
	private String isShow;

	/** update_by. */
	private String updateBy;

	/** update_time. */
	private Date updateTime;

	/** del_flag. */
	private String delFlag;

	/** remarks. */
	private String remarks;

	/** The set of pm_sys_role_menu. */
	private Set<PmSysRoleMenu> pmSysRoleMenuSet;

	/**
	 * Constructor.
	 */
	public PmSysMenu() {
		this.pmSysRoleMenuSet = new HashSet<PmSysRoleMenu>();
	}

	/**
	 * Set the menu_id.
	 * 
	 * @param menuId
	 *            menu_id
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	/**
	 * Get the menu_id.
	 * 
	 * @return menu_id
	 */
	public Integer getMenuId() {
		return this.menuId;
	}

	/**
	 * Set the menu_name.
	 * 
	 * @param menuName
	 *            menu_name
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * Get the menu_name.
	 * 
	 * @return menu_name
	 */
	public String getMenuName() {
		return this.menuName;
	}

	/**
	 * Set the parent_id.
	 * 
	 * @param parentId
	 *            parent_id
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * Get the parent_id.
	 * 
	 * @return parent_id
	 */
	public Integer getParentId() {
		return this.parentId;
	}

	/**
	 * Set the sort.
	 * 
	 * @param sort
	 *            sort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * Get the sort.
	 * 
	 * @return sort
	 */
	public Integer getSort() {
		return this.sort;
	}

	/**
	 * Set the href.
	 * 
	 * @param href
	 *            href
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * Get the href.
	 * 
	 * @return href
	 */
	public String getHref() {
		return this.href;
	}

	/**
	 * Set the target.
	 * 
	 * @param target
	 *            target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * Get the target.
	 * 
	 * @return target
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * Set the icon.
	 * 
	 * @param icon
	 *            icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * Get the icon.
	 * 
	 * @return icon
	 */
	public String getIcon() {
		return this.icon;
	}

	/**
	 * Set the permission.
	 * 
	 * @param permission
	 *            permission
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * Get the permission.
	 * 
	 * @return permission
	 */
	public String getPermission() {
		return this.permission;
	}

	/**
	 * Set the is_show.
	 * 
	 * @param isShow
	 *            is_show
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	/**
	 * Get the is_show.
	 * 
	 * @return is_show
	 */
	public String getIsShow() {
		return this.isShow;
	}

	/**
	 * Set the update_by.
	 * 
	 * @param updateBy
	 *            update_by
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * Get the update_by.
	 * 
	 * @return update_by
	 */
	public String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * Set the update_time.
	 * 
	 * @param updateTime
	 *            update_time
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * Get the update_time.
	 * 
	 * @return update_time
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * Set the del_flag.
	 * 
	 * @param delFlag
	 *            del_flag
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * Get the del_flag.
	 * 
	 * @return del_flag
	 */
	public String getDelFlag() {
		return this.delFlag;
	}

	/**
	 * Set the remarks.
	 * 
	 * @param remarks
	 *            remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Get the remarks.
	 * 
	 * @return remarks
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * Set the set of the pm_sys_role_menu.
	 * 
	 * @param pmSysRoleMenuSet
	 *            The set of pm_sys_role_menu
	 */
	public void setPmSysRoleMenuSet(Set<PmSysRoleMenu> pmSysRoleMenuSet) {
		this.pmSysRoleMenuSet = pmSysRoleMenuSet;
	}

	/**
	 * Add the pm_sys_role_menu.
	 * 
	 * @param pmSysRoleMenu
	 *            pm_sys_role_menu
	 */
	public void addPmSysRoleMenu(PmSysRoleMenu pmSysRoleMenu) {
		this.pmSysRoleMenuSet.add(pmSysRoleMenu);
	}

	/**
	 * Get the set of the pm_sys_role_menu.
	 * 
	 * @return The set of pm_sys_role_menu
	 */
	public Set<PmSysRoleMenu> getPmSysRoleMenuSet() {
		return this.pmSysRoleMenuSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PmSysMenu other = (PmSysMenu) obj;
		if (menuId == null) {
			if (other.menuId != null) {
				return false;
			}
		} else if (!menuId.equals(other.menuId)) {
			return false;
		}
		return true;
	}

}
