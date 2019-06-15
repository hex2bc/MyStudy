package Algorithm.mooc.pertest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 自测-2 素数对猜想
 * https://pintia.cn/problem-sets/17/problems/261
 * Created by hex2bc on 2019/6/13.
 */
public class TwinPrime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int result = 0;
        for (int i = 3; i < a; i += 2) {
            if (isTwinPrime(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    static int[] twins = new int[] {
            3, 5, 11, 17, 29, 41, 59, 71, 101, 107, 137, 149, 179, 191, 197, 227, 239, 269, 281, 311, 347,
            419, 431, 461, 521, 569, 599, 617, 641, 659, 809, 821, 827, 857, 881, 1019, 1031, 1049, 1061, 1091, 1151,
            1229, 1277, 1289, 1301, 1319, 1427, 1451, 1481, 1487, 1607, 1619, 1667, 1697, 1721, 1787, 1871, 1877, 1931, 1949, 1997,
            2027, 2081, 2087, 2111, 2129, 2141, 2237, 2267, 2309, 2339, 2381, 2549, 2591, 2657, 2687, 2711, 2729, 2789, 2801, 2969,
            2999, 3119, 3167, 3251, 3257, 3299, 3329, 3359, 3371, 3389, 3461, 3467, 3527, 3539, 3557, 3581, 3671, 3767, 3821, 3851,
            3917, 3929, 4001, 4019, 4049, 4091, 4127, 4157, 4217, 4229, 4241, 4259, 4271, 4337, 4421, 4481, 4517, 4547, 4637, 4649,
            4721, 4787, 4799, 4931, 4967, 5009, 5021, 5099, 5231, 5279, 5417, 5441, 5477, 5501, 5519, 5639, 5651, 5657, 5741, 5849,
            5867, 5879, 6089, 6131, 6197, 6269, 6299, 6359, 6449, 6551, 6569, 6659, 6689, 6701, 6761, 6779, 6791, 6827, 6869, 6947,
            6959, 7127, 7211, 7307, 7331, 7349, 7457, 7487, 7547, 7559, 7589, 7757, 7877, 7949, 8009, 8087, 8219, 8231, 8291, 8387,
            8429, 8537, 8597, 8627, 8819, 8837, 8861, 8969, 8999, 9011, 9041, 9239, 9281, 9341, 9419, 9431, 9437, 9461, 9629, 9677,
            9719, 9767, 9857, 9929, 10007, 10037, 10067, 10091, 10139, 10271, 10301, 10331, 10427, 10457, 10499, 10529, 10709, 10859, 10889, 10937,
            11057, 11069, 11117, 11159, 11171, 11351, 11489, 11549, 11699, 11717, 11777, 11831, 11939, 11969, 12041, 12071, 12107, 12161, 12239, 12251,
            12377, 12539, 12611, 12821, 12917, 13001, 13007, 13217, 13337, 13397, 13679, 13691, 13709, 13721, 13757, 13829, 13877, 13901, 13931, 13997,
            14009, 14081, 14249, 14321, 14387, 14447, 14549, 14561, 14591, 14627, 14867, 15137, 15269, 15287, 15329, 15359, 15581, 15641, 15647, 15731,
            15737, 15887, 15971, 16061, 16067, 16139, 16187, 16229, 16361, 16451, 16631, 16649, 16691, 16829, 16901, 16979, 17027, 17189, 17207, 17291,
            17387, 17417, 17489, 17579, 17597, 17657, 17681, 17747, 17789, 17837, 17909, 17921, 17957, 17987, 18041, 18047, 18059, 18119, 18131, 18251,
            18287, 18311, 18521, 18539, 18911, 18917, 19079, 19139, 19181, 19211, 19379, 19421, 19427, 19469, 19541, 19697, 19751, 19841, 19889, 19961,
            19991, 20021, 20147, 20231, 20357, 20441, 20477, 20507, 20549, 20639, 20717, 20747, 20771, 20807, 20897, 20981, 21011, 21017, 21059, 21191,
            21317, 21377, 21491, 21521, 21557, 21587, 21599, 21611, 21647, 21737, 21839, 22037, 22091, 22109, 22157, 22271, 22277, 22367, 22481, 22541,
            22571, 22619, 22637, 22697, 22739, 22859, 22961, 23027, 23039, 23057, 23201, 23291, 23369, 23537, 23561, 23627, 23669, 23687, 23741, 23831,
            23909, 24107, 24179, 24371, 24419, 24917, 24977, 25031, 25169, 25301, 25307, 25409, 25469, 25577, 25601, 25799, 25847, 25931, 25997, 26111,
            26249, 26261, 26681, 26699, 26711, 26729, 26861, 26879, 26891, 26951, 27059, 27107, 27239, 27281, 27407, 27479, 27527, 27539, 27581, 27689,
            27737, 27749, 27791, 27917, 27941, 28097, 28109, 28181, 28277, 28307, 28349, 28409, 28547, 28571, 28619, 28661, 28751, 29021, 29129, 29207,
            29387, 29399, 29567, 29669, 29759, 29879, 30011, 30089, 30137, 30269, 30389, 30467, 30491, 30557, 30839, 30851, 30869, 31079, 31121, 31151,
            31181, 31247, 31319, 31391, 31511, 31541, 31721, 31727, 31769, 31847, 32027, 32057, 32117, 32141, 32189, 32297, 32321, 32369, 32411, 32441,
            32531, 32561, 32609, 32717, 32801, 32831, 32909, 32939, 32969, 33071, 33149, 33179, 33287, 33329, 33347, 33587, 33599, 33617, 33749, 33767,
            33809, 33827, 34031, 34127, 34157, 34211, 34259, 34301, 34367, 34469, 34499, 34511, 34589, 34649, 34757, 34841, 34847, 34961, 35051, 35081,
            35279, 35447, 35507, 35531, 35591, 35729, 35801, 35837, 35897, 36011, 36107, 36341, 36467, 36527, 36779, 36791, 36899, 36929, 37019, 37199,
            37307, 37337, 37361, 37547, 37571, 37589, 37691, 37781, 37811, 37991, 38237, 38327, 38447, 38459, 38567, 38609, 38651, 38669, 38711, 38747,
            38921, 39041, 39161, 39227, 39239, 39341, 39371, 39509, 39827, 39839, 40037, 40127, 40151, 40427, 40529, 40637, 40697, 40847, 41141, 41177,
            41201, 41231, 41387, 41411, 41519, 41609, 41759, 41849, 41957, 41981, 42017, 42071, 42179, 42221, 42281, 42407, 42461, 42569, 42641, 42701,
            42839, 42899, 43049, 43319, 43397, 43541, 43577, 43607, 43649, 43781, 43787, 43889, 43961, 44027, 44087, 44129, 44201, 44267, 44279, 44381,
            44531, 44621, 44699, 44771, 45119, 45137, 45179, 45317, 45341, 45587, 45821, 46049, 46091, 46181, 46271, 46307, 46349, 46439, 46589, 46679,
            46769, 46817, 46829, 47057, 47147, 47351, 47387, 47417, 47657, 47699, 47711, 47741, 47777, 47807, 48119, 48311, 48407, 48479, 48539, 48647,
            48677, 48731, 48779, 48821, 48857, 48869, 48989, 49031, 49121, 49169, 49199, 49277, 49331, 49367, 49391, 49409, 49529, 49547, 49667, 49739,
            49787, 49919, 49937, 49991, 50021, 50051, 50129, 50261, 50459, 50549, 50591, 50891, 50969, 51059, 51131, 51197, 51239, 51341, 51347, 51419,
            51437, 51479, 51719, 51767, 51827, 51869, 51971, 52067, 52181, 52289, 52361, 52541, 52709, 52859, 52901, 53087, 53147, 53171, 53231, 53267,
            53279, 53549, 53591, 53609, 53717, 53897, 54011, 54401, 54419, 54497, 54539, 54581, 54629, 54917, 55049, 55217, 55331, 55337, 55439, 55619,
            55631, 55661, 55817, 55901, 55931, 56039, 56099, 56207, 56237, 56267, 56477, 56501, 56531, 56597, 56711, 56807, 56891, 56909, 56921, 57191,
            57221, 57269, 57329, 57347, 57527, 57557, 57791, 57899, 58109, 58151, 58169, 58229, 58367, 58391, 58439, 58451, 58601, 58787, 58907, 59009,
            59021, 59051, 59207, 59219, 59357, 59417, 59441, 59471, 59627, 59669, 60089, 60101, 60167, 60257, 60647, 60659, 60761, 60887, 60899, 60917,
            61151, 61331, 61379, 61469, 61559, 61979, 62129, 62141, 62189, 62297, 62927, 62969, 62981, 62987, 63029, 63197, 63311, 63389, 63419, 63587,
            63599, 63647, 63689, 63839, 64151, 64187, 64301, 64451, 64577, 64661, 64781, 64877, 64919, 65027, 65099, 65171, 65267, 65447, 65519, 65537,
            65579, 65699, 65717, 65729, 65837, 65927, 65981, 66107, 66359, 66569, 66749, 66851, 66947, 67139, 67187, 67211, 67217, 67271, 67409, 67427,
            67577, 67757, 67931, 68111, 68207, 68279, 68447, 68489, 68711, 68819, 68879, 68897, 69029, 69149, 69191, 69257, 69401, 69491, 69497, 69737,
            69761, 69827, 69857, 69929, 70001, 70121, 70139, 70181, 70199, 70379, 70457, 70487, 70571, 70619, 70841, 70877, 70919, 70949, 70979, 70997,
            71261, 71327, 71339, 71387, 71411, 71471, 71549, 71711, 71807, 71879, 72089, 72101, 72167, 72221, 72227, 72251, 72269, 72467, 72647, 72671,
            72869, 73037, 73061, 73361, 73607, 73679, 73847, 74099, 74159, 74201, 74381, 74411, 74507, 74609, 74717, 74729, 74759, 75011, 75167, 75209,
            75389, 75401, 75539, 75617, 75707, 75989, 76001, 76079, 76157, 76259, 76367, 76421, 76541, 76649, 76829, 76871, 76961, 77237, 77261, 77267,
            77417, 77477, 77489, 77549, 77687, 77711, 78137, 78191, 78437, 78509, 78539, 78569, 78779, 78887, 78977, 79151, 79229, 79397, 79559, 79631,
            79691, 79697, 79811, 79841, 79901, 79997, 80147, 80207, 80231, 80447, 80471, 80489, 80627, 80669, 80681, 80747, 80777, 80831, 80909, 81017,
            81041, 81047, 81197, 81281, 81371, 81551, 81647, 81701, 81899, 81929, 81971, 82007, 82037, 82139, 82217, 82349, 82469, 82529, 82559, 82721,
            82727, 82757, 82811, 82889, 83219, 83231, 83267, 83339, 83399, 83561, 83639, 83717, 84059, 84179, 84221, 84317, 84347, 84389, 84521, 84629,
            84809, 84857, 84869, 84977, 85091, 85199, 85331, 85361, 85427, 85451, 85619, 85667, 85817, 85829, 85931, 86027, 86111, 86291, 86351, 86369,
            86531, 86627, 86927, 87011, 87119, 87149, 87179, 87221, 87251, 87509, 87539, 87557, 87587, 87629, 87641, 87719, 87959, 88001, 88259, 88337,
            88469, 88589, 88607, 88661, 88799, 88811, 88817, 89069, 89519, 89561, 89597, 89657, 89669, 89819, 89897, 90017, 90071, 90197, 90371, 90401,
            90437, 90527, 90617, 90677, 90821, 91079, 91097, 91127, 91139, 91151, 91367, 91457, 91571, 91811, 91967, 92177, 92219, 92381, 92399, 92459,
            92567, 92639, 92669, 92681, 92789, 92861, 92957, 93131, 93239, 93251, 93281, 93479, 93491, 93557, 93701, 93761, 93809, 93887, 93911, 94007,
            94109, 94151, 94307, 94349, 94397, 94439, 94529, 94541, 94559, 94649, 94847, 94949, 95087, 95189, 95231, 95441, 95789, 95801, 95957, 95987,
            96179, 96221, 96329, 96587, 96737, 96797, 96821, 97001, 97157, 97169, 97301, 97367, 97379, 97499, 97547, 97577, 97607, 97649, 97787, 97841,
            97847, 97859, 98009, 98297, 98321, 98387, 98561, 98639, 98711, 98729, 98807, 98867, 98897, 98909, 98927, 99131, 99137, 99257, 99347, 99527,
            99707, 99719, 99989
    };

    public static boolean isTwinPrime(int num) {
        int index = Arrays.binarySearch(twins, num);
        if (index >= 0) return true;
        return false;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            int mod = num % i;
            if (mod == 0) return false;
        }
        return true;
    }
}
