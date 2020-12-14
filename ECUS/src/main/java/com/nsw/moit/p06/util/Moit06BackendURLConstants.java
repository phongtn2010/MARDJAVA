package com.nsw.moit.p06.util;

public class Moit06BackendURLConstants {

	public static final String ROOT_URL = "moit.06.backend";

	public final class TbdHoSo6Constants {

		private TbdHoSo6Constants() {}

		public static final String CREATE = "/moit/06/hoSo/create";
		public static final String UPDATE = "/moit/06/hoSo/update";
		public static final String DELETE = "/moit/06/hoSo/delete";
		public static final String GET_ONE = "/moit/06/hoSo/get";
		public static final String FIND_BY_MA_HO_SO = "/moit/06/hoSo/findByMaHoSo";
		public static final String FIND_BY_ID_HO_SO = "/moit/06/hoSo/findByIdHoSo";
		public static final String SEARCH = "/moit/06/hoSo/search";
		public static final String COUNT = "/moit/06/hoSo/count";

	}

	public final class TbdDinhKem6Constants {

		private TbdDinhKem6Constants() {}

		public static final String CREATE = "/moit/06/tepTin/create";
		public static final String UPDATE = "/moit/06/tepTin/update";
		public static final String DELETE = "/moit/06/tepTin/delete";
		public static final String GET_ONE = "/moit/06/tepTin/get";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_TEP_TIN_ASC = "/moit/06/tepTin/findByIdHoSoAndHoatDong";
		public static final String GET_BY_TEP_DINH_KEMS = "/moit/06/tepTin/getByTepDinhKems";

	}

	public final class TbdHangHoa6Constants {

		private TbdHangHoa6Constants() {}

		public static final String CREATE = "/moit/06/hangHoa/create";
		public static final String UPDATE = "/moit/06/hangHoa/update";
		public static final String DELETE = "/moit/06/hangHoa/delete";
		public static final String GET_ONE = "/moit/06/hangHoa/get";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_HANG_HOA_ASC = "/moit/06/hangHoa/findByIdHoSoAndHoatDong";

	}

	public final class TbdCuaKhau6Constants {

		private TbdCuaKhau6Constants() {}

		public static final String CREATE = "/moit/06/cuaKhau/create";
		public static final String UPDATE = "/moit/06/cuaKhau/update";
		public static final String DELETE = "/moit/06/cuaKhau/delete";
		public static final String GET_ONE = "/moit/06/cuaKhau/get";
		public static final String FIND_BY_ID_HO_SO_AND_MA_CUA_KHAU = "/moit/06/cuaKhau/findByIdHoSoAndMaCuaKhau";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_CUA_KHAU_ASC = "/moit/06/cuaKhau/findByIdHoSoAndHoatDong";
		public static final String GET_ALL_CUA_KHAUS = "/moit/06/cuaKhau/getAllCuaKhaus";

	}

	public final class TbdGiayPhep6Constants {

		private TbdGiayPhep6Constants() {}

		public static final String CREATE = "/moit/06/giayPhep/create";
		public static final String UPDATE = "/moit/06/giayPhep/update";
		public static final String DELETE = "/moit/06/giayPhep/delete";
		public static final String GET_ONE = "/moit/06/giayPhep/get";
		public static final String FIND_BY_ID_HO_SO = "/moit/06/giayPhep/findByIdHoSo";
		public static final String FIND_BY_MA_SO_G_P = "/moit/06/giayPhep/findBySoGiayPhep";

	}

	public final class TbdYCRut6Constants {

		private TbdYCRut6Constants() {}

		public static final String CREATE = "/moit/06/yeuCauRut/create";
		public static final String UPDATE = "/moit/06/yeuCauRut/update";
		public static final String DELETE = "/moit/06/yeuCauRut/delete";
		public static final String GET_ONE = "/moit/06/yeuCauRut/get";
		public static final String FIND_BY_ID_HO_SO = "/moit/06/yeuCauRut/findByIdHoSo";

	}

	public final class TbdKQXL6Constants {

		private TbdKQXL6Constants() {}

		public static final String CREATE = "/moit/06/ketQuaXuLy/create";
		public static final String UPDATE = "/moit/06/ketQuaXuLy/update";
		public static final String DELETE = "/moit/06/ketQuaXuLy/delete";
		public static final String GET_ONE = "/moit/06/ketQuaXuLy/get";
		public static final String SEARCH_KET_QUA_XU_LYS = "/moit/06/ketQuaXuLy/searchKetQuaXuLys";
		public static final String COUNT_KET_QUA_XU_LYS = "/moit/06/ketQuaXuLy/countHoSos";

	}

	public final class TbdTTPT6Constants {

		private TbdTTPT6Constants() {}

		public static final String CREATE = "/moit/06/phuongTien/create";
		public static final String UPDATE = "/moit/06/phuongTien/update";
		public static final String DELETE = "/moit/06/phuongTien/delete";
		public static final String GET_ONE = "/moit/06/phuongTien/get";
		public static final String FIND_BY_ID_HO_SO_AND_LOAI_PHUONG_TIEN = "/moit/06/phuongTien/findByIdHoSoAndLoaiPhuongTien";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_PHUONG_TIEN_ASC = "/moit/06/phuongTien/findByIdHoSoAndHoatDong";

	}

	public final class TbsCuaKhau6Constants {

		private TbsCuaKhau6Constants() {}

		public static final String GET_ONE = "/moit/06/tbsCuaKhau/get";
		public static final String FIND_BY_ID_CUA_KHAU = "/moit/06/tbsCuaKhau/findByIdCuaKhau";
		public static final String FIND_BY_ID_CUA_KHAU_IS_NOT_NULLORDER_BY_TEN_CUA_KHAU_ASC = "/moit/06/tbsCuaKhau/findByIdCuaKhauIsNotNull";
		public static final String GET_ALL = "/moit/06/tbsCuaKhau/getAll";

	}

	public final class TbsPhuongTien6Constants {

		private TbsPhuongTien6Constants() {}

		public static final String GET_ONE = "/moit/06/tbsPhuongTien/get";
		public static final String FIND_BY_ID_PHUONG_TIEN_IS_NOT_NULLORDER_BY_TEN_PHUONG_TIEN_ASC = "/moit/06/tbsPhuongTien/findByIdPhuongTienIsNotNull";
		public static final String FIND_BY_ID_PHUONG_TIEN = "/moit/06/tbsPhuongTien/findByIdPhuongTien";
		public static final String GET_ALL = "/moit/06/tbsPhuongTien/getAll";

	}

	public final class TbsTrangThai6Constants {

		private TbsTrangThai6Constants() {}

		public static final String GET_ONE = "/moit/06/tbsTrangThai/get";
		public static final String FIND_BY_ID_TRANG_THAI = "/moit/06/tbsTrangThai/findByIdTrangThai";
		public static final String FIND_BY_ID_TRANG_THAI_IS_NOT_NULLORDER_BY_ID_TRANG_THAI = "/moit/06/tbsTrangThai/findByIdTrangThaiIsNotNull";
		public static final String GET_ALL = "/moit/06/tbsTrangThai/getAll";

	}

	public final class TbsTienChat6Constants {

		private TbsTienChat6Constants() {}

		public static final String GET_ONE = "/moit/06/tienChat/get";
		public static final String FIND_BY_ID_TIEN_CHAT = "/moit/06/tienChat/findByIdTienChat";
		public static final String FIND_BY_ID_TIEN_CHAT_IS_NOT_NULLORDER_BY_TEN_TIEN_CHAT = "/moit/06/tienChat/findByIdTienChatIsNotNullOrderByTenTienChat";

	}

	public final class TbdLichSu6Constants {

		private TbdLichSu6Constants() {}

		public static final String CREATE = "/moit/06/lichSu/create";
		public static final String UPDATE = "/moit/06/lichSu/update";
		public static final String DELETE = "/moit/06/lichSu/delete";
		public static final String GET_ONE = "/moit/06/lichSu/get";
		public static final String SEARCH_KET_QUA_XU_LYS = "/moit/06/lichSu/search";
		public static final String COUNT_KET_QUA_XU_LYS = "/moit/06/lichSu/countHoSos";

	}
	
	public final class TbdGPHangHoa6Constants {

		private TbdGPHangHoa6Constants() {}

		public static final String CREATE = "/moit/06/gpHangHoa/create";
		public static final String UPDATE = "/moit/06/gpHangHoa/update";
		public static final String DELETE = "/moit/06/gpHangHoa/delete";
		public static final String GET_ONE = "/moit/06/gpHangHoa/get";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_HANG_HOA_ASC = "/moit/06/gpHangHoa/findByIdHoSoAndHoatDong";

	}

	public final class TbdGPCuaKhau6Constants {

		private TbdGPCuaKhau6Constants() {}

		public static final String CREATE = "/moit/06/gpCuaKhau/create";
		public static final String UPDATE = "/moit/06/gpCuaKhau/update";
		public static final String DELETE = "/moit/06/gpCuaKhau/delete";
		public static final String GET_ONE = "/moit/06/gpCuaKhau/get";
		public static final String FIND_BY_ID_HO_SO_AND_MA_CUA_KHAU = "/moit/06/gpCuaKhau/findByIdHoSoAndMaCuaKhau";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_CUA_KHAU_ASC = "/moit/06/gpCuaKhau/findByIdHoSoAndHoatDong";

	}

	public final class TbdGPTTPT6Constants {

		private TbdGPTTPT6Constants() {}

		public static final String CREATE = "/moit/06/gpPhuongTien/create";
		public static final String UPDATE = "/moit/06/gpPhuongTien/update";
		public static final String DELETE = "/moit/06/gpPhuongTien/delete";
		public static final String GET_ONE = "/moit/06/gpPhuongTien/get";
		public static final String FIND_BY_ID_HO_SO_AND_LOAI_PHUONG_TIEN = "/moit/06/gpPhuongTien/findByIdHoSoAndLoaiPhuongTien";
		public static final String FIND_BY_ID_HO_SO_AND_HOAT_DONGORDER_BY_ID_PHUONG_TIEN_ASC = "/moit/06/gpPhuongTien/findByIdHoSoAndHoatDong";

	}



}