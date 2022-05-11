/*
SQLyog Job Agent v12.09 (64 bit) Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 5.7.17 : Database - anime_website_database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`anime_website_database` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `anime_website_database`;

/*Table structure for table `anime_drama_management_table` */

DROP TABLE IF EXISTS `anime_drama_management_table`;

CREATE TABLE `anime_drama_management_table` (
  `animeNumber` varchar(100) NOT NULL,
  `animeName` varchar(100) NOT NULL,
  `animeType` varchar(100) NOT NULL,
  `animeAuthor` varchar(100) NOT NULL,
  `animePublishTime` varchar(100) NOT NULL,
  `animeRecommendIndex` varchar(100) NOT NULL,
  `animeIntroduction` longtext,
  PRIMARY KEY (`animeNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `anime_drama_management_table` */

insert  into `anime_drama_management_table` values ('20211210A100','人形电脑天使心','人生感悟','CLAMP','2001年02月','5星','人形电脑天使心是一部于2000年9月至2002年10月连载于日本讲谈社《周刊Young Magazine》上的漫画作品，于2002年被改编为同名电视动画。作者为知名女性漫画家团体CLAMP。《Chobits》是她们在青年漫画杂志上连载的第一部作品。作品以拥有人形外表的电脑已被普及的世界为舞台，讲述了一位隐藏着秘密的电脑少女与一位普通青年之间的恋爱物语。'),('20211210A101','夏目友人帐','人生感悟','白泉社','2003年06月','5星','故事讲述了夏目贵志从外祖母夏目玲子的遗物中得到了那些由契约书所做成的“友人帐”，他决定将友人帐中妖怪们的名字一一归还。在夏目身边，开始聚集起各种各样的妖怪们。能看到妖怪的少年夏目贵志，与招财猫外表的妖怪斑一起，为大家讲述一个个奇异、悲伤、怀念、令人感动的温馨故事。'),('20211210A102','樱花庄的宠物女孩','人生感悟','ASCII Media Works Inc.','2010年01月','5星','小说主要讲述了就读水明艺术大学附属高中的神田空太，一年级的夏天时在宿舍中养猫，而被校长叫去问话，校长让他在丢掉猫与从此搬到\"樱花庄\"中作选择。身为爱猫一族的空太，暂时选择了流落到因聚集各种怪人而恶名昭著的“樱花庄”。 隔年春天，随着世界级天才画家椎名真白搬进了樱花庄，神田空太开始过起被这名缺乏常识的少女耍得团团转的日子。'),('20211210A103','小鸠','人生感悟','CLAMP','2004年12月','5星','花户小鸠是漫画作品《奇迹少女KOBATO.》中女主角，因为有一个想要到达的地方而来到人间，为了实现这个愿望，必需不断收集人们受伤的心灵并将其碎片放进“瓶子”里。受了伤的心被治愈后就会变成像金平糖一样的碎片进入“瓶子”里。一次偶然，一个艾草托儿所陷入危机面临解散，人手不足的关键时刻出手相助。在和园长还有在保育园工作的藤本以及孩子们的接触中，这个不谙世事的少女的心在一点点发生着改变。'),('20211210A104','电波女与青春男','人生感悟','ASCII Media Works','2009年01月','5星','在谣传宇宙人看守的小镇上，住往姑母家事成之主人公・丹羽真。在等候他的乃是以棉被席卷成刑的电波女！不但如此、“地球正遭窥伺啦”“自己继承宇宙人之血啦”言行举动也都是电波那玩意儿。但说起学校的话则邂逅天然治愈系的流子同学、及模特儿体形的COSPLAYER前川同学而青春饱满……试看看。将向往宇宙的幢景给乘便送去、有点不可思议的故事。'),('20211210A105','ReLIFE','人生感悟','Earth Star Entertainment','2013年10月','5星','两次考研失败、因为种种原因毕业后只在新公司呆了三个月就辞职、使得自己再就业困难、现年27岁生活几乎毫无坐落的海崎新太，在一次夜晚朋友聚会后被一位神秘人物夜明叫住了，以保证之后一年的生活费供应和一年后保证就业条件为饵，诱使其加入到服用某种药物恢复成17岁的模样、并就读于某高校高中三年级的重生实验当中。经过再三犹豫，新太服用了药物参加了该实验。自此，海崎新太以高中三年生的外貌身份重新开始了为期一年的“重拾三观”校园生活。'),('20211210A106','致不灭的你','人生感悟','讲谈社','2016年11月','5星','最初它只是一个圆球，能幻化成为世间万物。它被投入到世界之中度过悠久时间之后，化身成野狼的模样……永生不死的它，一边习惯着这肉体一边展开了另一段旅程，直至它遇见了一位独自生活在白雪世界的少年。'),('20211210A107','星之梦','人生感悟','david production','2004年11月','5星','网络动画《星之梦》改编自Key同名游戏，是planetarian的起始篇，动画由david production负责制作。2016年4月1日宣布动画化，4月15日宣布为WEB动画，并且还公布了剧场版动画《星之人》上映详情。Key在Character1上配信了《星之梦》的PV并获得了大量游客驻足。2016年5月27日晚21：00，Key在ニコニコ直播访谈并收获了近两万名观众，并获得了94.4%的“とてもよっかた”。此后官网公布了C90的消息。'),('20211210A108','魔卡少女樱','魔法世界','CLAMP','1996年06月','5星','木之本樱，是就读于友枝小学的小学4年级学生。与父亲和哥哥3人一起生活。一天，小樱在父亲的书房发现一本奇怪的书。那本书中是会给这个世界带来灾难的“库洛牌”！为了回收散布各处的库洛牌，小樱成为了“魔卡捕获者”并不断奋斗……'),('20211210A109','从零开始的异世界生活','魔法世界','白狐社','2012年04月','4星','走出便利店要回家的高中生‧菜月昴突然被召唤到异世界。这莫非就是很流行的异世界召唤？可是眼前没有召唤者就算了，还遭遇强盗迅速面临性命危机。这时，一名神秘银发美少女和猫精灵拯救了一筹莫展的他。以报恩为名义，昴自告奋勇要帮助少女找东西。然而，好不容易才掌握到线索，昴和少女却被不明人士攻击而殒命——本来应该是这样，但回过神来，昴却发现自己置身在第一次被召唤到这个异世界时的所在位置。“死亡回归”——无力的少年得到的唯一能力，是死后时间会倒转回到一开始。跨越无数绝望，从死亡的命运中拯救少女。“即使你忘记了，我也不会忘记你。”'),('20211210A110','天体的秩序','萝莉废萌','Studio 3Hz','2014年10月','4星','某日在雾弥湖的上空中出现了谜样的圆盘，一度造成全世界的混乱与恐慌，但飞碟却只停留在空中，并没有进一步的行动。在时间流逝中人们渐渐对这件事失去了兴趣……就在两名少女相遇后，静止的时间再次流动，让众人有所改变的全新故事展开，中学生活最后那一年，将拥有一生无法忘怀的回忆。'),('20211210A111','漫画女孩','萝莉废萌','芳文社','2014年05月','4星','萌田薰子（笔名：混沌）15岁。女子高中生、四格漫画家！搬进漫画家专用的女子宿舍的她，被同室的少女漫画家小梦和TL漫画家琉姬、少年漫画家翼等同伴们所围绕，今天也愉快地绘制原稿，彻夜工作！可爱又有趣的漫画家生活就此开幕！'),('20211210A112','属性咖啡厅','萝莉废萌','芳文社','2017年10月','4星','来到了有着傲娇、妹系等各种“属性”的咖啡厅，新人店员莓香竟然被店长要求\"抖S\"属性！？努力工作的同时，意外的也让\"抖S\"才能渐渐开花……充满欢乐的打工由此展开！'),('20211210A113','若叶女孩','萝莉废萌','芳文社','2013年10月','4星','外貌秀丽却很憧憬“GAL”的大小姐若叶，天真无邪的童话少女萌子，奔放而又总是一时兴起的真鱼，以及原本是运动少女、现在却爱好BL的直。这是一部描绘个性洋溢的少女们日常的故事。'),('20211210A114','TARITARI','青春校园','P.A.WORKS','2012年07月','4星','故事的舞台设定在神奈川县江之岛的湘南，讲述进入了高中音乐系的坂井和奏却在半途因为母亲突然去世在自责的情况下放弃了音乐的道路，之后便转入了普通系，在她升入高中三年级时，以与宫本来夏、冲田纱羽的相遇为契机加上田中大智与新生前田敦博组成了合唱和羽毛球部，就这样再次与音乐相联系，青春群像剧也正式开演了。'),('20211210A115','吹响吧,上低音号','青春校园','京阿尼','2013年12月','4星','进入北宇治高中就读的主人公黄前久美子，在同班同学加藤叶月的热烈影响下加入了该校的吹奏部。北宇治高中吹奏部直到5年前还是关西大会的常客，并且过去还是全国大会出场过的强校代表，然而自从顾问换了之后，该吹奏部就再也没有挺进过关西大会。之后以新顾问的赴任为契机，怀揣着高远目标的部员们挥洒着奋斗的青春，过着波澜万丈的每一天。终于，比赛的日子也即将到来……'),('20211210A116','轻音少女','青春校园','京阿尼','2007年04月','5星','春季，新生决定加入的社团的时节。田井中律带着发小秋山澪到轻音部参观。可是全体部员都已经毕业的轻音部，如果不能重新召集起4名成员就会被废部。加上了琴吹䌷这个伙伴，正在寻找最后一人的时候，把轻音部误解为“轻松的音乐”的乐器新手——平泽唯来到了社团活动室。'),('20211210A117','LoveLive','青春校园','电击Gs magazine、日昇、Lantis','2010年01月','4星','一所位于东京都千代田区的传统高校“音乃木坂学院”，因为入读的学生人数骤减，所以正面临着废校的危机。其中有九名少女想到一条妙计——成为偶像，只要她们成为偶像，学校的名气便会增加，而入读学生的人数亦会上升。就这样，九位个性鲜明的少女决定一起努力成为偶像，希望可以凭借偶像的名气增加生源来挽救自己所喜爱的校园。'),('20211210A118','鬼灭之刃','热血战斗','集英社','2016年02月','5星','时值日本大正时期。 传说太阳下山后，有恶鬼出没吃人。亦有猎鬼人斩杀恶鬼、保护人们。卖炭少年炭治郎，他那平凡而幸福的日常生活，在家人遭到恶鬼袭击的那一天发生了剧变。母亲与四个弟弟妹妹惨遭杀害，而与他一起生还的妹妹祢豆子亦异变成凶暴的鬼。在猎鬼人的指引下，立志成为猎鬼人的炭治郎与变成鬼却尚存理智的祢豆子踏上了旅程。通过艰苦的剑术修行与赌命试炼，炭治郎成为了猎鬼人组织“鬼杀队”的一员。为了让妹妹祢豆子变回人类，为了讨伐杀害家人的恶鬼，为了斩断悲伤的连锁，少年与鬼的战斗不曾停歇。幸福被破坏之时，总是弥漫着鲜血的味道。纵然我身俱灭，定将恶鬼斩杀！血风剑戟冒险谭，开幕！'),('20211210A119','小林家的龙女仆','日常搞笑','京阿尼','2013年05月','5星','尽管托尔认为人类都是愚蠢的生物，但是因为此前小林对她有恩同意收留她和在初次相遇的一番交谈感动了她并且使她极度喜欢上了小林而全力以赴地为她提供服务。这就是一个龙娘和一个每天为了生活而奔波的白领之间发生的日常喜剧。'),('20211210A120','玉子市场','日常搞笑','京阿尼','2004年12月','4星','坐落于某个小镇的兔山商店街（うさぎ山商店街）上，有个经营饼店的少女－－北白川玉子。除了帮忙店里的事情，她亦有跟学校的朋友常盘绿和牧野神奈参与舞棒部活动。而饼店对面的大路家是同一行业的竞争对手，两边的父亲经常都因生意问题而喧闹一番。然而大路家的儿子大路饼藏却是玉子的朋友，但玉子从没注意到饼藏的好感。总而言之，玉子在商店街众人的护荫下，热闹地度过每一天，生活可谓过得相当快乐。'),('20211210A121','宇崎学妹想要玩','日常搞笑','KADOKAWA/富士见书房','2017年12月','4星','性格有些孤僻喜爱安静的大学三年级学生，樱井真一，总是被小一届，同高中毕业的学妹宇崎花，以各种照顾爱耍孤僻的学长的名义为由，进行各种无厘头的纠缠。虽然一开始觉得有点困扰，但却逐渐习惯起来。'),('20211210A122','这个美术社大有问题','日常搞笑','角川书店','2012年10月','4星','存在于平凡无奇的普通学校“月杜中学”的普通美术部。那里有着虽有绘画才能却只为了描绘理想的“二次元新娘”而燃起使命的内卷昴同学，以及对无可救药的内卷同学感到在意的宇佐美瑞希同学。以及，对两人似乎关注又似乎没有关注、总在睡觉的部长，和总带着不可思议气息的神秘部员可蕾特同学。这样稍微有些遗憾的人们所集中的美术部，今天也在发生着什么问题——'),('20211210A123','CLANNAD','催泪治愈','京阿尼','2007年10月','5星','在某个小镇，主角冈崎朋也因家庭因素成为不良少年，一直与春原阳平为伍，在光坂高校过着潦倒的生活，但希望终有一天能够离开所在的小镇。某一天，他在学校坡道前发现了一个止步不前的女孩，在朋也认识了这个名为“古河渚”的女孩后，他的生活开始有了重大的变化。'),('20211210A124','未闻花名','催泪治愈','A-1 Pictures','2011年04月','5星','《我们仍未知道那天所看见的花的名字。》是一部用直达内心的笔触描写青春期的少男少女在面对恋情、友情、纠葛时，有欢欣笑容也有伤心泪水的青春原创动画。'),('20220503A162','One Room','萝莉废萌','SMIRAL','2017-01-18','4星','《One Room》的舞台，发生在“主角（One）的居室（Room）”当中。观众们将会跟三位少女轮番邂逅，并跟三位少女展开一段以主角的居室为中心的故事。'),('20220517A748','请问你今天要来点兔子吗','催泪治愈','芳文社','2015-06-10','4星','由于作者想在木造建筑小镇所构成的世界里，描述咖啡的故事，所以开始这部漫画的创作。同时，作者广泛涉猎了法国的史特拉斯堡，德国的科尔马结晶，匈牙利的温泉西洋棋，接触融合了各地各式各样的世界观，并且将其粗略加工成为了创作作品的素材，融入到了故事当中。'),('20220518A350','你的名字','青春校园','新海诚','2017-06-07','5星','故事发生的地点是在每千年回归一次的彗星造访过一个月之前，日本飞驒市的乡下小町糸守町。在这里女高中生三叶每天都过着忧郁的生活，而她烦恼的不光有担任町长的父亲所举行的选举运动，还有家传神社的古老习俗。在这个小小的町，周围都只是些爱瞎操心的老人。为此三叶对于大都市充满了憧憬。\r\n然而某一天，自己做了一个变成男孩子的梦。这里有着陌生的房间、陌生的朋友。而眼前出现的则是东京的街道。三叶虽然感到困惑，但是能够来到朝思暮想的都市生活，让她觉得神清气爽。另一方面在东京生活的男高中生立花泷也做了个奇怪的梦，他在一个从未去过的深山小町中，变成了女高中生。两人就这样在梦中邂逅了彼此。'),('20220548A949','路人女主的养成方法','青春校园','富士见书房','2012-07-20','5星','故事是叙述御宅族安艺伦也，在把一名不起眼的少女培养成体面的女主角之余，更以她为蓝本制作出美少女游戏的感人经历，但什么长处都没有的伦也就忽然说要制作游戏，事情没有那么容易，拥有满腔的热忱伦也开始企划游戏方案，企划书无数次被学姐霞之丘诗羽揉成了团丢掉，但伦也并没有放弃，就这样，培养第一女主角的育成喜剧开演。');

/*Table structure for table `anime_music_management_table` */

DROP TABLE IF EXISTS `anime_music_management_table`;

CREATE TABLE `anime_music_management_table` (
  `musicNumber` varchar(100) NOT NULL,
  `musicName` varchar(100) NOT NULL,
  `musicType` varchar(100) NOT NULL,
  `musicSinger` varchar(100) NOT NULL,
  `musicRecommendIndex` varchar(100) NOT NULL,
  PRIMARY KEY (`musicNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `anime_music_management_table` */

insert  into `anime_music_management_table` values ('20211210Y100','Dream Land! Dream World!','偶像团体','A·ZU·NA','5星'),('20211210Y101','元気全開DAY! DAY! DAY!','偶像团体','CYaRon','5星'),('20211210Y102','GALAXY HidE and SeeK','偶像团体','AZALEA','5星'),('20211210Y103','空中恋愛論','偶像团体','AZALEA','5星'),('20211210Y104','トリコリコPLEASE!!','偶像团体','AZALEA','5星'),('20211210Y105','NO EXIT ORION','偶像团体','Printemps','5星'),('20211210Y106','CHANGELESS','偶像团体','CYaRon','5星'),('20211210Y107','冬がくれた予感','偶像团体','BiBi','5星'),('20211210Y108','僕たちはひとつの光','偶像团体','μ’s','5星'),('20211210Y109','秋のあなたの空遠く','偶像团体','lily white','5星'),('20211210Y110','春情ロマンティック','偶像团体','lily white','5星'),('20211210Y111','虹色Passions!','偶像团体','虹咲学园偶像同好会','5星'),('20211210Y112','Sing & Smile!!','偶像团体','QU4RTZ','5星'),('20211210Y113','SKY JOURNEY','偶像团体','Aqours','5星'),('20211210Y114','乙姫心で恋宮殿','偶像团体','lily white','5星'),('20211210Y115','小夜啼鳥恋詩','偶像团体','Printemps','5星'),('20211210Y116','夢がここからはじまるよ','偶像团体','虹咲学园偶像同好会','5星'),('20211210Y117','キミのくせに!','偶像团体','lily white','5星'),('20211210Y118','ダイアモンド','偶像团体','中须霞 ','5星'),('20211210Y119','Hello, 星を数えて','偶像团体','μ’s一年级组','5星'),('20211210Y120','永遠に咲く花','动漫歌曲','AiRI','5星'),('20211210Y121','Mb','动漫歌曲','安野希世乃','5星'),('20211210Y122','Candy a Mine','动漫歌曲','茶太','5星'),('20211210Y123','Twinkle Starlight','动漫歌曲','佐咲纱花','5星'),('20220504M056','orion','抒情乐曲','米津玄师','5星'),('20220519M503','君色シグナル','动漫主题曲','春奈るな ','4星'),('20220519M865','霍元甲','古风','周杰伦','5星'),('20220525M567','游生梦死','未知','Eve','5星'),('20220529M310','lemon','抒情乐曲','米津玄师','5星'),('20220531M639','等你下课','抒情情歌','周杰伦','5星'),('20220537M776','Stargazer','治愈空灵','饭田里穂','4星');

/*Table structure for table `annual_plan_table` */

DROP TABLE IF EXISTS `annual_plan_table`;

CREATE TABLE `annual_plan_table` (
  `userName` varchar(100) NOT NULL,
  `location` varchar(10) NOT NULL,
  `planContent` varchar(255) NOT NULL,
  `planNotes` varchar(100) NOT NULL,
  `planGenerateDate` date DEFAULT NULL,
  PRIMARY KEY (`userName`,`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `annual_plan_table` */

insert  into `annual_plan_table` values ('LongRich','1','获得CET-4证书','6月11号考试','2020-04-07'),('LongRich','2','获得CET-4证书','6月11号考试','2022-05-20'),('LongRich','3','获得CET-4证书','6月11号考试','2022-04-29'),('LongRich','5','逆风局','成本麻烦','2022-05-06'),('LongRich','6','梵蒂冈恢复光滑','士大夫士大夫','2022-04-29'),('LongRich','7','日语达到N4水平','明年之前','2022-06-29'),('LongRich','8','日语达到N4水平','明年之前','2022-06-29'),('LongRich','9','达成A级报告','难','2022-04-30');

/*Table structure for table `data_analysis_management_table` */

DROP TABLE IF EXISTS `data_analysis_management_table`;

CREATE TABLE `data_analysis_management_table` (
  `graphNumber` int(100) NOT NULL,
  `graphDate` varchar(100) NOT NULL,
  `graphUserDayRegisterQuantity` varchar(100) NOT NULL,
  `graphUserDayLoginQuantity` varchar(100) NOT NULL,
  `graphUserRegisterTotal` varchar(100) NOT NULL,
  `jinPinPurchaseQuantity` varchar(100) NOT NULL,
  `musicClicksQuantity` varchar(100) NOT NULL,
  `animeClicksQuantity` varchar(100) NOT NULL,
  PRIMARY KEY (`graphNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `data_analysis_management_table` */

insert  into `data_analysis_management_table` values (1,'星期一','12','6','12','5','12','54'),(2,'星期二','15','4','27','2','25','12'),(3,'星期三','16','8','43','6','41','22'),(4,'星期四','10','2','53','7','22','58'),(5,'星期五','11','4','64','4','30','36');

/*Table structure for table `data_generated_daily` */

DROP TABLE IF EXISTS `data_generated_daily`;

CREATE TABLE `data_generated_daily` (
  `dataId` varchar(100) NOT NULL,
  `userDailyRegis` int(100) NOT NULL,
  `dailyLoginOfUsers` int(100) NOT NULL,
  `dailyPurchasesOfJinpin` int(100) NOT NULL,
  `dateTime` date NOT NULL,
  PRIMARY KEY (`dataId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `data_generated_daily` */

insert  into `data_generated_daily` values ('2022050916data0068',15,23,35,'2022-05-03'),('2022050916data0363',45,15,52,'2022-05-04'),('2022050916data1727',12,56,23,'2022-05-05'),('2022050916data2381',15,32,32,'2022-05-06'),('2022050916data2644',35,21,20,'2022-05-07'),('2022050916data6888',42,11,11,'2022-05-08'),('2022050916data7039',30,35,21,'2022-05-09'),('2022051033data8961',6,2,40,'2022-05-10');

/*Table structure for table `expand_skills_table` */

DROP TABLE IF EXISTS `expand_skills_table`;

CREATE TABLE `expand_skills_table` (
  `userName` varchar(100) NOT NULL,
  `location` varchar(10) NOT NULL,
  `firstItemName` varchar(100) NOT NULL,
  `firstItemData` varchar(100) NOT NULL,
  `secondItemName` varchar(100) NOT NULL,
  `secondItemData` varchar(100) NOT NULL,
  `thirtItemName` varchar(100) NOT NULL,
  `thirtItemData` varchar(100) NOT NULL,
  `fourthItemName` varchar(100) NOT NULL,
  `fourthItemData` varchar(100) NOT NULL,
  `fifthItemName` varchar(100) NOT NULL,
  `fifthItemData` varchar(100) NOT NULL,
  PRIMARY KEY (`userName`,`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `expand_skills_table` */

/*Table structure for table `jinpin_model_management_table` */

DROP TABLE IF EXISTS `jinpin_model_management_table`;

CREATE TABLE `jinpin_model_management_table` (
  `jinPinNumber` varchar(100) NOT NULL,
  `jinPinName` varchar(100) NOT NULL,
  `jinPinType` varchar(100) NOT NULL,
  `jinPinManufacturer` varchar(100) NOT NULL,
  `jinPinPrice` varchar(100) NOT NULL,
  `jinPinRecommendIndex` varchar(100) NOT NULL,
  PRIMARY KEY (`jinPinNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jinpin_model_management_table` */

insert  into `jinpin_model_management_table` values ('2021112110jp1001','香风智乃','春天','ANIPLEX+','936.00','5星'),('2021112110jp1002','涅普迪努','次元的旅人','GSC','1320.00','5星'),('2021112110jp1003','艾米莉亚','偶像组合','SSF','5810.00','5星'),('2021112110jp1004','涅普迪努','起床','BROCCOLI！','910.00','5星'),('2021112110jp1005','少女前线','黑猫的赠礼','HobbyMax','523.00','5星'),('2021112110jp1006','鹿目圆','盛装','F:NEX','846.00','5星'),('2021112110jp1007','爱丽丝','光辉天使','SSF','1254.00','5星'),('2021112110jp1008','香奈呼','鬼灭之刃','ALTER','652.00','5星'),('2021112110jp1009','加藤惠','睡衣','TAITO','109.00','5星'),('2021112110jp1010','加藤惠','制服','TAITO','109.00','5星'),('2021112110jp1011','鹿乃','虚拟偶像','TAITO','99.00','5星'),('2021112110jp1012','芹泽朝日','闪耀色彩','TAITO','109.00','5星'),('2021112110jp1013','凉宫春日','制服','角川','932.00','5星'),('2021112110jp1014','阿库娅','花魁','ALTER','887.00','5星'),('2021112110jp1015','加藤惠','Racing','TAITO','863.00','5星'),('2021112110jp1016','志摩凛','摇曳露营','GSC','350.00','5星'),('2021112110jp1017','蝴蝶忍','鬼灭之刃','ALTER','525.00','5星'),('2021112110jp1018','蕾姆','圣诞之夜','ALTER','437.00','5星'),('2021112110jp1019','宫泽风花','白沙水族馆','GSC','1435.00','5星'),('2021112110jp1020','佩可莉姆','公主连结','GSC','338.00','5星'),('2021112110jp1021','香风智乃','魔法使','Stronger','736.00','5星'),('2021112110jp1022','木之本樱','魔卡少女樱','ALTER','1524.00','5星'),('2021112110jp1023','碧翠丝','Q版手办','Stronger','336.00','5星'),('2022050508JP1840','龙王的工作','常服','TAITO','219','5星'),('2022050548JP9865','吹响吧上低音号','常规','我不知道','999','5星');

/*Table structure for table `log_management_table` */

DROP TABLE IF EXISTS `log_management_table`;

CREATE TABLE `log_management_table` (
  `logNumber` varchar(100) NOT NULL,
  `executor` varchar(100) NOT NULL,
  `executeEvent` varchar(100) NOT NULL,
  `accessInterface` varchar(100) NOT NULL,
  `remark` varchar(100) NOT NULL,
  `executionTime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`logNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `log_management_table` */

insert  into `log_management_table` values ('2022050801Log8014','kasumi','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1002','2022-05-08 07:59:01'),('2022050803Log6136','kasumi','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1004','2022-05-08 07:59:03'),('2022050805Log0654','kasumi','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1010','2022-05-08 07:59:05'),('2022050807Log8547','kasumi','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1009','2022-05-08 07:59:07'),('2022050809Log2008','kasumi','执行了将景品从购物车删除的操作','/ShoppingCart/deleteShoppingCartData','暂无备注！','2022-05-08 07:59:09'),('2022050810Log5889','kasumi','执行了将景品从购物车删除的操作','/ShoppingCart/deleteShoppingCartData','暂无备注！','2022-05-08 07:59:10'),('2022050814Log0063','kasumi','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 07:59:14'),('2022050814Log1179','kasumi','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 07:59:14'),('2022050814Log1245','kasumi','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 07:59:14'),('2022050814Log1955','kasumi','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 07:59:14'),('2022050814Log2261','kasumi','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 07:59:14'),('2022050814Log4568','kasumi','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 07:59:14'),('2022050814Log6399','kasumi','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 07:59:14'),('2022050814Log9980','kasumi','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 07:59:14'),('2022050816Log1192','rubi','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-08 05:28:16'),('2022050817Log1962','kasumi','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-08 07:59:17'),('2022050821Log1810','rubi','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-08 05:28:21'),('2022050826Log2203','getZero','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-08 05:30:26'),('2022050828Log6929','honaga','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-08 05:28:28'),('2022050830Log8845','honaga','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-08 05:28:30'),('2022050833Log2092','getZero','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-08 08:20:33'),('2022050839Log2826','kasumi','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-08 07:58:39'),('2022050841Log5885','getZero','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 08:21:41'),('2022050841Log9224','getZero','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-08 08:21:41'),('2022050842Log3156','hanamaru','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-08 05:28:42'),('2022050844Log2112','hanamaru','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-08 05:28:44'),('2022050845Log4248','kasumi','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-08 07:58:45'),('2022050847Log9080','kasumi','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-08 07:58:47'),('2022050849Log3312','kasumi','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-08 07:58:49'),('2022050850Log8828','kasumi','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-08 07:58:50'),('2022050851Log1298','kasumi','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-08 07:58:51'),('2022050854Log3359','kasumi','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-08 07:58:54'),('2022050857Log5389','kasumi','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-08 07:58:57'),('2022050905Log3372','getZero','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-09 01:17:05'),('2022051002Log3483','getZero','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 06:58:02'),('2022051003Log3487','honaga','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1004','2022-05-10 07:13:03'),('2022051003Log5474','honaga','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1004','2022-05-10 07:13:03'),('2022051004Log4395','honaga','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1009','2022-05-10 07:13:04'),('2022051004Log6248','honaga','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1009','2022-05-10 07:13:04'),('2022051008Log1502','getZero','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1004','2022-05-10 06:58:08'),('2022051008Log4016','getZero','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1004','2022-05-10 06:58:08'),('2022051008Log8310','getZero','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1004','2022-05-10 06:58:08'),('2022051010Log0401','honaga','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:13:10'),('2022051010Log2242','honaga','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:13:10'),('2022051010Log2567','honaga','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:13:10'),('2022051010Log4578','honaga','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:13:10'),('2022051010Log5104','honaga','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:13:10'),('2022051010Log6666','honaga','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:13:10'),('2022051010Log6886','honaga','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:13:10'),('2022051010Log9671','honaga','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:13:10'),('2022051013Log0749','honaga','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-10 07:13:13'),('2022051015Log5085','游客用户','执行了注册操作','/login/addRegisteredInfor','暂无备注！','2022-05-10 05:09:15'),('2022051015Log6852','kanada','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 07:16:15'),('2022051016Log4323','游客用户','执行了注册操作','/login/addRegisteredInfor','暂无备注！','2022-05-10 05:08:16'),('2022051017Log2608','游客用户','执行了注册操作','/login/addRegisteredInfor','暂无备注！','2022-05-10 07:14:17'),('2022051017Log7309','honaga','执行了将景品从购物车删除的操作','/ShoppingCart/deleteShoppingCartData','暂无备注！','2022-05-10 07:12:17'),('2022051018Log0711','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:18'),('2022051018Log2361','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:18'),('2022051018Log5903','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:18'),('2022051019Log1012','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:19'),('2022051019Log3268','honaga','执行了将景品从购物车删除的操作','/ShoppingCart/deleteShoppingCartData','暂无备注！','2022-05-10 07:12:19'),('2022051019Log6344','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:19'),('2022051019Log6899','honaga','执行了将景品从购物车删除的操作','/ShoppingCart/deleteShoppingCartData','暂无备注！','2022-05-10 07:12:19'),('2022051019Log7540','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:19'),('2022051020Log0132','honaga','执行了将景品从购物车删除的操作','/ShoppingCart/deleteShoppingCartData','暂无备注！','2022-05-10 07:12:20'),('2022051020Log1303','honaga','执行了将景品从购物车删除的操作','/ShoppingCart/deleteShoppingCartData','暂无备注！','2022-05-10 07:12:20'),('2022051020Log4521','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:20'),('2022051020Log4639','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:20'),('2022051020Log4742','getZero','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 06:57:20'),('2022051020Log4983','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:20'),('2022051020Log7839','kanada','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:16:20'),('2022051020Log8689','游客用户','执行了注册操作','/login/addRegisteredInfor','暂无备注！','2022-05-10 05:07:20'),('2022051021Log3333','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:21'),('2022051022Log3350','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:22'),('2022051022Log5115','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:22'),('2022051022Log5876','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:22'),('2022051022Log6673','kanada','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1003','2022-05-10 07:16:22'),('2022051022Log7410','kanada','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1003','2022-05-10 07:16:22'),('2022051022Log7700','getZero','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 04:22:22'),('2022051022Log8210','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:22'),('2022051022Log9382','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:22'),('2022051023Log4511','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:23'),('2022051024Log3118','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:24'),('2022051024Log3896','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:24'),('2022051024Log4765','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:24'),('2022051024Log5985','getZero','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-10 07:03:24'),('2022051024Log7342','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:24'),('2022051024Log8686','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:24'),('2022051024Log8947','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:24'),('2022051024Log9574','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:24'),('2022051025Log1790','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:25'),('2022051025Log8804','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:25'),('2022051026Log0442','游客用户','执行了注册操作','/login/addRegisteredInfor','暂无备注！','2022-05-10 07:15:26'),('2022051026Log0906','kanada','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1004','2022-05-10 07:16:26'),('2022051026Log6638','kanada','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1004','2022-05-10 07:16:26'),('2022051026Log9860','getZero','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 05:09:26'),('2022051027Log1477','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:27'),('2022051027Log2510','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:27'),('2022051027Log3951','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:27'),('2022051027Log8823','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:27'),('2022051028Log3146','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:28'),('2022051028Log3533','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:28'),('2022051028Log4306','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:28'),('2022051028Log4612','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:28'),('2022051028Log4758','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:28'),('2022051028Log5046','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:28'),('2022051028Log5293','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:28'),('2022051028Log7008','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:28'),('2022051028Log7708','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:28'),('2022051029Log1002','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:29'),('2022051029Log3878','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:29'),('2022051029Log6041','kanada','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 07:13:29'),('2022051029Log7124','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:29'),('2022051029Log7539','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:29'),('2022051029Log8050','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:29'),('2022051030Log0893','kanada','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:16:30'),('2022051030Log1220','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:30'),('2022051030Log1619','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:30'),('2022051030Log3397','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:30'),('2022051030Log3931','kanada','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:16:30'),('2022051030Log4172','kanada','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:16:30'),('2022051030Log4916','kanada','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:16:30'),('2022051030Log5178','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:30'),('2022051030Log5822','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:30'),('2022051030Log5826','kanada','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:16:30'),('2022051030Log5915','kanada','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:16:30'),('2022051030Log6132','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:30'),('2022051030Log6562','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:30'),('2022051030Log6927','kanada','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:16:30'),('2022051030Log9639','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:30'),('2022051030Log9874','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:30'),('2022051030Log9926','kanada','执行了获取个人信息的操作','/individual/getPersonalInformationData','暂无备注！','2022-05-10 07:16:30'),('2022051031Log3057','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:31'),('2022051031Log3089','honaga','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 07:07:31'),('2022051031Log5614','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:12:31'),('2022051032Log0827','kanada','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-10 07:16:32'),('2022051032Log5996','kanada','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-10 07:13:32'),('2022051035Log1771','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:35'),('2022051035Log3910','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:35'),('2022051035Log8604','honaga','执行了添加景品到购物车的操作','/ShoppingCart/addJinpinToShoppingCart','暂无备注！','2022-05-10 07:09:35'),('2022051038Log8538','honaga','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 07:03:38'),('2022051040Log5534','honaga','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1002','2022-05-10 07:11:40'),('2022051040Log6813','honaga','执行了添加一个景品到购物车的操作','/ShoppingCart/addJinPinPurchaseQuantity','2021112110jp1002','2022-05-10 07:11:40'),('2022051041Log8965','getZero','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 07:16:41'),('2022051045Log4485','honaga','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 07:12:45'),('2022051049Log1471','kari','执行了登陆操作','/login/loginInfor','暂无备注','2022-05-10 07:15:49'),('2022051056Log5653','kari','执行了登出操作','/login/loginInfor','缓存数据以及删除！','2022-05-10 07:15:56');

/*Table structure for table `notes_management_table` */

DROP TABLE IF EXISTS `notes_management_table`;

CREATE TABLE `notes_management_table` (
  `notesId` varchar(100) NOT NULL,
  `notesTitle` varchar(100) NOT NULL,
  `notesContent` longtext NOT NULL,
  `formationTime` date NOT NULL,
  PRIMARY KEY (`notesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notes_management_table` */

insert  into `notes_management_table` values ('2022050746Notes2980','你的名字','想见的人，不能忘记的人，不想忘记的人，你？是谁？','2017-07-13'),('2022050750Notes0907','本站说明','Anime网站是一个简单的前后端项目,主要采用Vue.js+SpringBoot技术栈开发','2021-09-10'),('2022050750Notes2373','日常','日々私たちが过ごしている日常というのは、実は奇迹の连続なのかもしれん.','2021-09-12'),('2022050750Notes2981','星之梦','欢迎大家光临天象馆，这里有着无论何时都决不会消失的，美丽无穷的光辉，满天的星星们正在等待着大家的到来。','2021-10-20'),('2022050750Notes6280','AIR','梦总是会有醒来的时候，不会醒的梦总有一天会变成悲伤。','2021-10-24'),('2022050750Notes6346','千与千寻','人永远不知道，谁哪次不经意的跟你说了再见之后，就真的不会再见了。','2021-10-25'),('2022050750Notes7357','空之境界','人不应该根据背负的罪孽而选择道路，而是应当在选择的道路上背负罪孽。','2021-11-04'),('2022050750Notes7898','樱花庄的宠物女孩','其实就在眼前，明明就在伸手可及的地方，但那距离却总让人觉得像是永远。','2021-11-09'),('2022050750Notes8358','萤火之森','如果时光可以倒流 我还是会选择认识你 虽然会伤痕累累 但是心中的温暖记忆是谁都无法给与的 谢谢你来过我的世界。','2022-05-07'),('2022050750Notes9606','言叶之庭','隐约雷鸣，阴霾天空，但盼风雨来，能留你在此。隐约雷鸣，阴霾天空，即使无风雨，我亦留此地。','2022-05-07'),('2022050750Notes9806','魔卡少女樱','自己喜欢的人的名字，不管什么状况都听得见吧！','2022-05-07');

/*Table structure for table `personal_information_table` */

DROP TABLE IF EXISTS `personal_information_table`;

CREATE TABLE `personal_information_table` (
  `userName` varchar(100) NOT NULL,
  `location` varchar(10) NOT NULL,
  `firstItemName` varchar(100) NOT NULL,
  `firstItemData` varchar(100) NOT NULL,
  `secondItemName` varchar(100) NOT NULL,
  `secondItemData` varchar(100) NOT NULL,
  `thirtItemName` varchar(100) NOT NULL,
  `thirtItemData` varchar(100) NOT NULL,
  `fourthItemName` varchar(100) NOT NULL,
  `fourthItemData` varchar(100) NOT NULL,
  `fifthItemName` varchar(100) NOT NULL,
  `fifthItemData` varchar(100) NOT NULL,
  PRIMARY KEY (`userName`,`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `personal_information_table` */

/*Table structure for table `professional_skill_table` */

DROP TABLE IF EXISTS `professional_skill_table`;

CREATE TABLE `professional_skill_table` (
  `userName` varchar(100) NOT NULL,
  `location` varchar(10) NOT NULL,
  `firstItemName` varchar(100) NOT NULL,
  `firstItemData` varchar(100) NOT NULL,
  `secondItemName` varchar(100) NOT NULL,
  `secondItemData` varchar(100) NOT NULL,
  `thirtItemName` varchar(100) NOT NULL,
  `thirtItemData` varchar(100) NOT NULL,
  `fourthItemName` varchar(100) NOT NULL,
  `fourthItemData` varchar(100) NOT NULL,
  `fifthItemName` varchar(100) NOT NULL,
  `fifthItemData` varchar(100) NOT NULL,
  `sixthItemName` varchar(100) NOT NULL,
  `sixthItemData` varchar(100) NOT NULL,
  PRIMARY KEY (`userName`,`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `professional_skill_table` */

insert  into `professional_skill_table` values ('LongRich','2','qwer','125','rew','521','sdf','125','xcv','521','vbr','125','nhf','521');

/*Table structure for table `shopping_cart_table` */

DROP TABLE IF EXISTS `shopping_cart_table`;

CREATE TABLE `shopping_cart_table` (
  `shoppingCartJinPinNumber` varchar(100) NOT NULL,
  `jinPinBuyingUser` varchar(100) NOT NULL,
  `jinPinPrice` varchar(100) NOT NULL,
  `jinPinPurchaseQuantity` varchar(100) NOT NULL,
  `jinPinTotalPrice` varchar(100) NOT NULL,
  PRIMARY KEY (`shoppingCartJinPinNumber`,`jinPinBuyingUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shopping_cart_table` */

insert  into `shopping_cart_table` values ('2021112110jp1001','yy','936.00','3','2808'),('2021112110jp1002','kasumi','1320.00','2','2640'),('2021112110jp1002','LongRich','1320.00','1','1320'),('2021112110jp1002','yy','1320.00','2','2640'),('2021112110jp1003','kanada','5810.00','6','34860'),('2021112110jp1004','getZero','910.00','4','3640'),('2021112110jp1004','honaga','910.00','7','6370'),('2021112110jp1004','kanada','910.00','8','7280'),('2021112110jp1004','kasumi','910.00','2','1820'),('2021112110jp1004','LongRich','910.00','1','910'),('2021112110jp1006','yy','846.00','1','846'),('2021112110jp1007','yy','1254.00','1','1254'),('2021112110jp1009','honaga','109.00','7','763'),('2021112110jp1009','kasumi','109.00','2','218'),('2021112110jp1009','LongRich','109.00','1','109'),('2021112110jp1010','honaga','109.00','5','545'),('2021112110jp1010','kasumi','109.00','2','218'),('2021112110jp1010','LongRich','109.00','1','109'),('2021112110jp1011','honaga','99.00','5','495'),('2021112110jp1011','kasumi','99.00','1','99'),('2021112110jp1011','LongRich','99.00','1','99'),('2021112110jp1011','yy','99.00','2','198'),('2021112110jp1014','yy','887.00','1','887'),('2021112110jp1023','yy','336.00','1','336');

/*Table structure for table `user_login_data_table` */

DROP TABLE IF EXISTS `user_login_data_table`;

CREATE TABLE `user_login_data_table` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salt` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `userPermission` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_login_data_table` */

insert  into `user_login_data_table` values ('ayomei','20aa6d5525ed148a958349c2b091c964','Jgz8^nl0','上原步美','18922692296','18922692296@qq.com','GeneralUser'),('daiya','10480b0ec0ca7ffe668b7280043aa41d','nHvnt5wO','黑泽黛雅','13184876591','13169485319@qq.com','GeneralUser'),('getZero','1922d64a06b7eff8e6b0d71256686c22','ZzlY@M#!','归零者','13169485319','2864659907@qq.com','Zeroer'),('hanabi','74409b433dc90e9d244f5262e4fe9928','7VdDC7mX','小泉花阳','13169485319','2864659907@qq.com','GeneralUser'),('hanamaru','b58221383b08259f0d9597d619ac4766','*sdY98)w','国木田花丸','13169485319','2864659907@qq.com','GeneralUser'),('honaga','fa6198ddd4303681a9b64aeafe4be4f5','x0x6bh8@','高板惠乃果','13169485319','2864659907@qq.com','GeneralUser'),('kanada','c61a71b7c9166a87b8092e1f3e45e1ca','EpPHhGXX','近江彼方','13169485319','2864659907@qq.com','GeneralUser'),('kari','a97e9fe03bc62de563d1b7063763a0ac','Ka4@Q*xO','朝香果林','13169485319','13169485319@qq.com','GeneralUser'),('kasumi','7b776f1b0ac8eeaad8180e8e2203b76b','#FTgaEmn','中须霞','13169485319','2864659907@qq.com','GeneralUser'),('LongRich','637a3be493afd0911784bb88d2d9fcc4','@C187p^V','曾长富','13169485319','2864659907@qq.com','GeneralUser'),('qika','ac94750648bb3157ec4b317d434fe71f','%&j2!E8U','高海千歌','13169485319','2864659907@qq.com','GeneralUser'),('rubi','c01130ea4f70252f82d6c0aa93ca1f9e','*Gmj5$0)','黑泽露比','13169485319','2864659907@qq.com','GeneralUser'),('you','f9955ed9a2bc039f7bbef86ed8ec7050','e@pJ(h13','渡边曜','13169485319','2864659907@qq.com','GeneralUser'),('yy','ef5283c2e8d6e6ebdb634d268bd1035b','WM%y*gpN','s','2132132132','adlkasjdlka@qq.com','GeneralUser');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
