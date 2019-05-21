
import os

root = '/Users/mygame/Movies/study'
out = './out/screenshot/'
EXTRACT_FREQUENCY = 900

video_file = ['.avi','.mp4','.mkv']
videos = []

def extract_frames(video_path, dst_folder, index):
    # 主操作
    import cv2
    video = cv2.VideoCapture()
    if not video.open(video_path):
        print("can not open the video")
        exit(1)
    count = 1
    while True:
        _, frame = video.read()
        if frame is None:
            break
        if count % EXTRACT_FREQUENCY == 0:
            save_path = "{}/{:>03d}.jpg".format(dst_folder, index)
            cv2.imwrite(save_path, frame)
            index += 1
        count += 1
    video.release()
    # 打印出所提取帧的总数
    print("Totally save {:d} pics".format(index-1))

def getAllVideo(rootDir):
    for lists in os.listdir(rootDir):
        path = os.path.join(rootDir, lists)
        if os.path.isdir(path):
            getAllVideo(path)
        elif os.path.splitext(path)[-1] in video_file:
            videos.append(path)
            # print(path)


def get_filePath_fileName_fileExt(filename):
    (filepath,tempfilename) = os.path.split(filename);
    (shotname,extension) = os.path.splitext(tempfilename);
    return filepath,shotname,extension


def main():
    getAllVideo(root)
    if not os.path.exists(out):
        os.mkdir(out)
    for video in videos:
        dest_path,filename,_ = get_filePath_fileName_fileExt(video)
        out_path = os.path.join(out,filename)
        if not os.path.exists(out_path):
            os.mkdir(out_path)
        extract_frames(video, out_path, 1)

    # print(videos)


if __name__ == '__main__':
    main()